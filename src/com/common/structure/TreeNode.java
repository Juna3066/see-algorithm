package com.common.structure;

/**
 * keypoint TreeNode（树节点数据结构） 典型具有递归性质的数据接口
 */
public class TreeNode {
    // keypoint 属性为了外包能访问，添加public
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "{val=" + val + '}';
    }
}