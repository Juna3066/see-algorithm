package com.sword2offer;

import com.common.structure.TreeNode;
import com.common.utils.TreeNodeUtil;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author JUN
 */
public class N54 {
    /**
     * question 面试题54.所有大于等于节点的值之和
     */
    public static void main(String[] args) {
        N54 n = new N54();
        TreeNode res = n.convertBST(TreeNodeUtil.deserialize("2,1,#,#,3,#,#"));
        String serialize = TreeNodeUtil.serialize(res);
        System.out.println("serialize = " + serialize);

    }

    /*
     * keypoint 左右相反的中序遍历，操作：累加值，更新到当前遍历节点
     *
     * 问题：
     * 1.递归的优点，缺点？栈迭代的优点，缺点？
     * 2.如何选择？
     */
    private TreeNode convertBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        int sum = 0;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.offerLast(cur);
                cur = cur.right;
            }
            TreeNode node = stack.pollLast();
            sum += node.val;
            node.val = sum;
            cur = node.left;
        }
        return root;
    }

    private TreeNode convertBSTV1(TreeNode root) {
        int[] sum = {0};
        return convertBST(root, sum);
    }

    private TreeNode convertBST(TreeNode node, int[] sum) {
        if (node == null) return null;
        convertBST(node.right, sum);
        sum[0] += node.val;
        node.val = sum[0];
        convertBST(node.left, sum);
        return node;
    }

}
