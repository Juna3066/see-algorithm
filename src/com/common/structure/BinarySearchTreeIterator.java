package com.common.structure;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * BST 二叉查找树，迭代器,数据结构设计
 * keypoint 把in-dfs拆分即可，外层循环是hasNext,内层循环是next
 */
public class BinarySearchTreeIterator {
    private TreeNode cur;
    private Deque<TreeNode> stack;

    public BinarySearchTreeIterator(TreeNode root) {
        this.stack = new ArrayDeque<>();
        this.cur = root;
    }

    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }

    public int next() {
        while (cur != null) {
            stack.offerLast(cur);
            cur = cur.left;
        }
        cur = stack.pollLast();
        int val = cur.val;
        cur = cur.right;
        return val;
    }
}
