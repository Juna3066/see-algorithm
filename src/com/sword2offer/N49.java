package com.sword2offer;

import com.common.structure.TreeNode;
import com.common.utils.TreeNodeUtil;

import java.util.ArrayList;
import java.util.List;

public class N49 {

    /**
     * question 49.从根节点到叶子结点，看作一条路经，求所有路径表示的数字之和
     */
    public static void main(String[] args) {
        N49 n = new N49();
        TreeNode deserialize = TreeNodeUtil.deserialize("3,9,5,#,#,1,#,#,0,#,2,#,#");
        int sum = n.pathSum(deserialize);
        System.out.println("sum = " + sum);
    }

    private int pathSum(TreeNode node) {
        int num = 0;
        return pathSum(node, num);
    }

    private int pathSum(TreeNode node, int num) {
        // 防止空指针异常 刚开始就是null 直接返回不用计算
        if (node == null)
            return 0;
        // keypoint 1.路径数字的计算方法，选择前序遍历 2.当是根节点的时候，返回最终结果。 3.如何递归
        num = num * 10 + node.val;
        if (node.left == null && node.right == null) {
            return num;
        }
        return pathSum(node.left, num) + pathSum(node.right, num);
    }

    private int pathSumV1(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        int num = 0;
        helper(node, list, num);
        System.out.println("list = " + list);
        return list.stream().reduce(0, Integer::sum);
    }

    // keypoint 为什么我不能第一时间相当带返回值的递归？
    private void helper(TreeNode node, List<Integer> list, int num) {
        if (node == null) return;
        num = num * 10 + node.val;
        if (node.left == null && node.right == null) {
            list.add(num);
        }
        helper(node.left, list, num);
        helper(node.right, list, num);
    }
}
