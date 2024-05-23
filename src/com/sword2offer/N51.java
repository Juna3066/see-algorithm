package com.sword2offer;

import com.common.structure.TreeNode;
import com.common.utils.TreeNodeUtil;

/**
 * 50min 两个番茄
 * @author JUN
 */
@SuppressWarnings("all")
public class N51 {
    /**
     * question 51.求【路径上】节点和的最大值
     * 难点是，此处的路径定义，的理解
     *
     */
    public static void main(String[] args) {
        N51 n = new N51();
        TreeNode node = TreeNodeUtil.deserialize("-9,4,#,#,20,15,-3,#,#,#,7,#,#");
        int maximum = n.pathMaxSum(node);
        System.out.println("maximum = " + maximum);
    }

    /*
     * keypoint  路径上的节点之和(路径拐弯)，如何计算？
     * 通过观察可知，计算最大值，有哪些情况，以根节点为例
     *      最大值，可能产生在？
     *      经过根节点，
     *      不经过根节点
     *          根节点的左子树
     *          根节点的右子树
     * 需要先计算左子树最大值、右子树最大值，在计算通过根节点的最大值。
     * 所以【用后续遍历】，
     * 【返回值】，返回的是什么？当前节点的子节点,到根节点的最大值.
     * 即node.val + max(node.left to left,node.right to leaf)
     */
    private int pathMaxSum(TreeNode node) {
        int[] max = {Integer.MIN_VALUE};
        postOrderDFS(node, max);
        return max[0];
    }

    private int postOrderDFS(TreeNode node, int[] max) {
        if (node == null) return 0;

        // keypoint 为什么选择 后序遍历
        int[] leftMax = {Integer.MIN_VALUE};
        int left = postOrderDFS(node.left, leftMax);
        int[] rightMax = {Integer.MIN_VALUE};
        int right = postOrderDFS(node.right, rightMax);

        // keypoint 根据路径最大值，的三种情况，求最大值
        int passCurMax = node.val + left + right;
        max[0] = Math.max(leftMax[0], rightMax[0]);
        max[0] = Math.max(max[0], passCurMax);

        // keypoint 返回值的理解，用于计算经过父节点最值的情况，的三个组成部分之一
        int passParentChildMax = node.val + Math.max(left, right);
        return passParentChildMax;
    }

}
