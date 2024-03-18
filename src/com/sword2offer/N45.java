package com.sword2offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JUN
 */
public class N45 {
    public static void main(String[] args) {
        N45 n = new N45();

        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(9);

        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setRight(node6);
        node6.setRight(new TreeNode(10));

        System.out.println(n.bottomLeftNode(node1));
    }

    /**
     * //局部变量 这需要初始化，不然编译不通过
     *
     * @param node
     * @return
     */
    public int bottomLeftNode(TreeNode node) {
        //题目说了 假设二叉树中最少有一个节点。
        /*if (node == null){
            return Integer.MIN_VALUE;
        }*/

        Queue<TreeNode> current = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        current.offer(node);
        int res = node.getVal();

        while (current.peek() != null) {
            TreeNode parent = current.poll();
            if (parent.getLeft() != null) {
                next.offer(parent.getLeft());
            }
            if (parent.getRight() != null) {
                next.offer(parent.getRight());
            }
            if (current.peek() == null) {
                if (next.peek()!=null){
                    res =next.peek().getVal();
                }
                current = next;
                next = new LinkedList<>();
            }

        }
        return res;
    }
}
