package com.sword2offer;

import com.common.enums.TraversalType;
import com.common.structure.TreeNode;
import com.common.utils.TreeNodeUtil;

import java.util.List;

public class N47 {
    /**
     * question 47.修剪二叉树，剪去全是0的子树
     */
    public static void main(String[] args) {
        N47 n = new N47();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(3);

        TreeNode node = n.pruneTree(root);
        List<Integer> res = TreeNodeUtil.preorderTraversal(root);
        System.out.println("res = " + res);
    }

    /*
     * keypoint 关键点，递归调用有返回值，且返回值：
     * 1.root==null,防止后续空指针异常，后续是修剪左右子树，并分别把结果更新到子树。
     * 2.如果更新后的左右子树null，且当前节点值0，即可返回null表示删除，否则返回自身。
     */
    private TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        return root.left == null && root.right == null && root.val == 0 ? null : root;
    }

}
