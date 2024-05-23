package com.sword2offer;

import com.common.structure.TreeNode;
import com.common.utils.TreeNodeUtil;
import java.util.HashSet;
import java.util.Stack;

/**
 *
 * @author JUN
 */
public class N56 {
    /**
     * question 二叉搜索树中(节点值唯一)，是否存在两个节点的值之和是K
     */
    public static void main(String[] args) {
        N56 n = new N56();
        TreeNode root = TreeNodeUtil.deserialize("8,6,5,#,#,7,#,#,10,9,#,#,11,#,#");
        int target = 11;
        boolean exist = findTarget(root, target);
        System.out.println(exist);
    }

    /*
     * keypoint 遍历二叉树 + 哈希表。 key = target - cur.val  set包含key返回true, 遍历完，没返回，则false。
     * 时间复杂度O(n)  空间复杂度 stack O(h) + set O(n)
     *
     * 优化空间复杂度
     *
     * 二叉查找树，可以看作排序数组，用前后双支针，求和。（前后迭代器）
     * pre.val post.val =  target 返回ture
     * pre.val post.val >  target, post左移。
     * pre.val post.val <  target，pre右移
     *
     * 空间复杂度 stack + stack
     */
    private static boolean findTarget(TreeNode root, int target) {
        HashSet<Integer> hashSet = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        // 逻辑运算符不小心写错了
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();

            //什么情况才是true呢？ 两个节点和= target   target-当前节点的值，去找之前已经存入的set节点值，找到就是true
            if (hashSet.contains(target - cur.val)) {
                return true;
            }
            hashSet.add(cur.val);
            cur = cur.right;
        }
        return false;
    }


}
