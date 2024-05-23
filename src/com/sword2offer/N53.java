package com.sword2offer;

import com.common.structure.TreeNode;
import com.common.utils.TreeNodeUtil;

/**
 *
 * 两种解法，时间复杂度，O(n) O(n)
 *
 * @author JUN
 */
public class N53 {
    /**
     * question 面试题53：二叉搜索树的下一个节点
     */
    public static void main(String[] args) {
        N53 n = new N53();
        TreeNode root = TreeNodeUtil.deserialize("6,3,1,#,#,4,#,#,9,7,#,#,10,#,#");
        int target = 3;
        TreeNode next = n.findNext(root, target);
        System.out.println("next = " + next);
    }

    private TreeNode findNext(TreeNode root, int target) {
        TreeNode cur = root;
        TreeNode res = null;
        while (cur != null) {
            if (cur.val > target) {
                //记录，可能的结果，分情况讨论
                res = cur;
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return res;
    }

}
