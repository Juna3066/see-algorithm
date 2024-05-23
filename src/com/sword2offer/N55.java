package com.sword2offer;

import com.common.structure.BinarySearchTreeIterator;
import com.common.structure.TreeNode;
import com.common.utils.TreeNodeUtil;

/**
 * @author JUN
 */
public class N55 {
    /**
     * question 面试题55.二叉搜索树迭代器
     */
    public static void main(String[] args) {
        N55 n = new N55();
        TreeNode root = TreeNodeUtil.deserialize("4,2,1,#,#,3,#,#,5,#,#");
        BinarySearchTreeIterator iterator = new BinarySearchTreeIterator(root);
        while (iterator.hasNext()) {
            int next = iterator.next();
            System.out.println(next);
        }
    }
}