package com.sword2offer;

import com.common.structure.TreeNode;

import java.util.Arrays;

public class N48 {
    /**
     * question 48.设计算法，二叉树序列化为字符串，字符串反序列化为二叉树
     */
    public static void main(String[] args) {
        //test();
        N48 n = new N48();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        String str = n.serialize(root);
        //1,2,3,#,#,4,#,#,5,6,#,#,7,#,#
        System.out.println("str = " + str);

        TreeNode node = n.deserialize(str);
        String serialize = n.serialize(node);
        System.out.println(serialize.equals(str));

    }

    /*
     * keypoint keypoint 和序列化结构基本一致，遍历字符串数组，递归调用，下标用数组传递。
     *   方法的参数是基本类型，引用类型的区别?
     *   基本类型，传递的值的副本，方法内改变它，【不能反馈到调用者】。
     *   引用类型，传递的引用地址的副本，方法改变引用对象的状态，【能反馈到调用者】。
     */
    private TreeNode deserialize(String str) {
        String[] split = str.split(",");
        return deserialize(split, new int[]{0});
    }

    private TreeNode deserialize(String[] array, int[] index) {
        String s = array[index[0]++];
        if ("#".equals(s)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = deserialize(array, index);
        node.right = deserialize(array, index);
        return node;
    }

    /*
     * keypoint 1.前序遍历 2.null节点用特殊字符#表示
     */
    private String serialize(TreeNode root) {
        return root == null ? "#" : root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    private static void test() {
        int a = 10;
        Integer b = Integer.valueOf(20);
        int[] c = {1, 2, 3, 4, 5};
        System.out.println("调用前的值：");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + Arrays.toString(c));
        modifyValues(a, b, c);
        System.out.println("\n调用后的值：");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + Arrays.toString(c));
    }

    public static void modifyValues(int x, Integer y, int[] z) {
        // 尝试修改基本数据类型的值
        x = 99;
        // 尝试修改引用数据类型的值
        y = Integer.valueOf(88);
        // 修改数组的第一个元素
        z[0] = 9;
    }

}
