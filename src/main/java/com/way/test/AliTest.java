package com.way.test;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wayleung
 * @description
 * @date 2020-08-19 19:40:59
 */
public class AliTest {
    public static void main(String[] args) throws IOException {
        File file  = new File("/Users/wayleung/work/test.txt");
        List<Tree> list = parseFile(file);
        Tree tree = buildTree(list);
//        System.out.println(tree);
        System.out.println(isValid(tree, "北京市", "平谷区", null));
        System.out.println(isValid(tree, "北京市", "天河区", null));
        System.out.println(isValid(tree, "北京市", "天河区", "武强县"));
        System.out.println(isValid(tree, "河北省", "衡水市", "武强县"));
        System.out.println(isValid(tree, "河北省", "衡水市", "武强县1"));
        System.out.println(isValid(tree, null, null, null));
//        System.out.println();
        printTree(tree);
    }


    /**
     * 解析文件
     * @param file
     * @return
     * @throws IOException
     */
    public static List<Tree> parseFile(File file) throws IOException {
        List<Tree> result = new ArrayList<>();
        InputStreamReader read = new InputStreamReader(new FileInputStream(file),"UTF-8");
        BufferedReader br= new BufferedReader(read);
        String line = null;
        try {
            while((line = br.readLine()) != null){
                Tree tree = parseString(line);
                result.add(tree);
            }
        }finally {
            br.close();
            read.close();
        }
        return result;
    }

    /**
     * 解析每行字符串
     * @param str
     * @return
     */
    public static Tree parseString(String str){
        Tree tree = new Tree();
        String[] split = str.split("-");
        if(split.length>0){
            String parentStr = split[0];
            String[] parentStrArray = parentStr.split(":");
            if(parentStrArray.length>0){
                tree.setParent(Integer.valueOf(parentStrArray[0]));
                tree.setParentArea(parentStrArray[1]);
            }
            String childStr = split[1];
            String[] childStrArray = childStr.split(":");
            if(childStrArray.length>0){
                tree.setData(Integer.valueOf(childStrArray[0]));
                tree.setArea(childStrArray[1]);
            }

            return tree;
        }else{
            return null;
        }
    }


    /**
     * 构建树
     * @param trees
     * @return
     */
    public static Tree buildTree(List<Tree> trees) {
        /**
         * groupingby 二级code 获取一个已经groupby的 二级-三级关系的map
         */
        Map<Integer, List<Tree>> tempChildrenMap = sortMap(trees.stream().filter(tree -> tree.getParent() != 0).sorted(Comparator.comparing(Tree::getData)).collect(Collectors.groupingBy(tree -> tree.getParent())));
        //todo 可优化
        /**
         * 获取map key所有二级关系的code
         */
        Set<Integer> keys = tempChildrenMap.keySet();
        /**
         * key所有二级关系的code构建一级-二级关系 零级-一级关系的Tree 其实应该先构建了Tree的List再转map
         */
        List<Tree> allTrees = getSecondAndOne(keys,trees);
        /**
         * groupingby 二级code 获取一个已经groupby的 二级-三级关系的map 完整数据
         */
        Map<Integer, List<Tree>> childrenMap = sortMap(allTrees.stream().filter(tree -> tree.getParent() != 0).sorted(Comparator.comparing(Tree::getData)).collect(Collectors.groupingBy(tree -> tree.getParent())));
        /**
         * 遍历 把所有的节点的children都关联上 引用类型 自然会一一关联
         */
        allTrees.forEach(tree -> tree.setChildren(childrenMap.get(tree.getData())));
        /**
         * 最后获取根节点
         */
        return allTrees.stream().filter(tree -> tree.getParent() == 0).collect(Collectors.toList()).get(0);
    }

    private static Map sortMap(Map<Integer, List<Tree>> childrenMap) {
        return childrenMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (oldVal, newVal) -> oldVal,
                                LinkedHashMap::new
                        )
                );
    }

    /**
     * key为二层节点 构建一二层节点
     */
    public static List<Tree> getSecondAndOne(Set<Integer> keys,List<Tree> trees){
        keys.forEach(key->{
            Tree tempTree = new Tree();
            tempTree.setParent(1);
            tempTree.setData(key);
            Tree tree = getTree(trees, key);
            tempTree.setArea(tree.getParentArea());
            trees.add(tempTree);
        });
        trees.add(new Tree(0,1,"中国",null,null));
        return trees;
    }

    /**
     * 根据data查找对应Tree
     * @param trees
     * @param data
     */
    public static Tree getTree(List<Tree> trees, Integer data){
        for(Tree tree:trees) {
            Integer dataTemp = tree.getParent();
            if(dataTemp.equals(data)){
                return tree;
            }
        }
        return null;
    }


    /**
     * 构建树
     * @param trees
     * @return
     */
    public static Map<Integer, List<Tree>> buildTreeMap(List<Tree> trees) {
        return trees.stream().filter(tree -> tree.getParent() != 1).collect(Collectors.groupingBy(tree -> tree.getParent()));
    }


    /**
     * 是否有孩子节点
     */
    public static boolean isHasChild(Tree tree){
        if(tree.getChildren()!=null&&tree.getChildren().size()>0&&tree.getChildren().get(0).getData()!=null){
            return true;
        }
        return false;
    }


    /**
     * 集合是否为空
     * @param list
     * @return
     */
    public static boolean isEmpty(List list){
        if(list!=null&&list.size()>0){
            return true;
        }
        return false;
    }


    /**
     * 判断地址是否合法
     * @param lv1
     * @param lv2
     * @param lv3
     * @return
     */
    public static boolean isValid(Tree tree,String lv1,String lv2,String lv3){
        if(!isHasChild(tree)){
            return false;
        }else{
            if(lv1!=null&&!lv1.equals("")){
                List<Tree> children = tree.getChildren();
                Tree tree1 = ifHasData(children, lv1);
                if(tree1!=null){
                    if(lv2!=null&&!lv2.equals("")){
                        Tree tree2 = ifHasData(tree1.getChildren(), lv2);
                        if(tree2!=null){
                            if(lv3!=null&&!lv3.equals("")){
                                Tree tree3 = ifHasData(tree2.getChildren(), lv3);
                                if(tree3!=null){
                                    return true;
                                }else{
                                    return false;
                                }
                            }else{
                                return true;
                            }
                        }else{
                            return false;
                        }
                    }else{
                        return true;
                    }
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
    }


    /**
     * 寻找是否有该节点 有的话返回
     * @param trees
     * @param area
     * @return
     */
    public static Tree ifHasData(List<Tree> trees,String area){
        for(Tree tree:trees){
            if(tree.getArea().equals(area)){
                return tree;
            }
        }
        return null;
    }


    static int lv = 0;
    public static void printTree(Tree tree){
        if(tree!=null){
            System.out.println(printBlank(lv)+"-" + tree.getData() + ":" + tree.getArea());
        }
        if(isHasChild(tree)){
            lv++;
            for (int i = 0; i < tree.getChildren().size(); i++) {
                printTree(tree.getChildren().get(i));
            }
            lv--;
        }
    }



    public static String printBlank(int n){
        String blank = "";
        for (int i = 0; i < n; i++) {
            blank = blank+" ";
        }
        return blank;
    }


}


/**
 * 地区树实体
 */
class Tree{
    private Integer parent;
    private Integer data;
    private String area;
    private String parentArea;
    private List<Tree> children;

    public String getParentArea() {
        return parentArea;
    }

    public void setParentArea(String parentArea) {
        this.parentArea = parentArea;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Tree() {
    }

    public Tree(Integer parent, Integer data, List<Tree> children) {
        this.parent = parent;
        this.data = data;
        this.children = children;
    }

    public Tree(Integer parent, Integer data,String area,String parentArea, List<Tree> children) {
        this.parent = parent;
        this.parentArea = parentArea;
        this.data = data;
        this.children = children;
        this.area = area;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public List<Tree> getChildren() {
        return children;
    }

    public void setChildren(List<Tree> children) {
        this.children = children;
    }


    @Override
    public String toString() {
//        return "-"+data+":"+area+children;

//        return "\n-"+data+":"+area+children;

        String result = "-"+data+":"+area;
        if(children!=null){
            result = result + "\n   "+children.toString();
        }
        return result;
    }
}