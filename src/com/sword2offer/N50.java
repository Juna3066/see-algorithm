package com.sword2offer;

import com.common.structure.TreeNode;
import com.common.utils.TreeNodeUtil;

import java.util.HashMap;

/**
 * @author JUN
 */
public class N50 {

    /**
     * question 统计，路径上所有节点值的和是，目标值，的路径的数量。
     * 此处路径定义：根节点，到某叶子节点上，任意选择开始，结束节点，构成一条路径。
     * 开始结束节点，可以是同一个节点。
     */
    public static void main(String[] args) {
        N50 n = new N50();
        //1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000
        TreeNode node = TreeNodeUtil.deserialize("1000000000,1000000000,294967296,1000000000,1000000000,1000000000,#,#,#,#,#,#,#");
//        TreeNode node = TreeNodeUtil.deserialize("5,2,1,#,#,6,#,#,4,3,#,#,7,#,#");
        int target = 0;
        int count = n.downPathSumCount(node, target);
        System.out.println("count = " + count);
    }

    /*
     * keypoint 1.路径相关，首先考虑用深度优先遍历。 2.路径的和相关，需要从头开始累加，用前序遍历
     * 3.定义map,key是根节点到当前节点的值之和，value是和，对应的数量，默认值1。初始放入map.put(0,1)
     * 4.path路径，可能长于目标路径。所以 key = sum - target 正常 >= 0  当key=0说明，相等。或key已经出现过，也说明能成。
     * 5.当前路径放入map,然后用于，左右子树count计算，累加，最终返回count
     *
     */
    private int downPathSumCount(TreeNode node, int target) {
        HashMap<Integer, Integer> sumCountMap = new HashMap<>();
        sumCountMap.put(0, 1);
        return downPathSumCount(node, target, 0, sumCountMap);
    }

    /**
     * @param node        代表二叉树的节点
     * @param target      和的目标值
     * @param sum         代表根节点到当前节点，路径和
     * @param sumCountMap key-向下的路径和 value-key对应的数量
     *                    key可以是：
     *                    1.从root到a节点
     *                    2.从root到a后的b节点，
     *                    3.a后下一个节点到b节点，路径和  初始放入值 [0,1]
     * @return 符合条件的路径数量
     */
    private int downPathSumCount(TreeNode node, int target, int sum, HashMap<Integer, Integer> sumCountMap) {
        if (node == null) return 0;
        sum += node.val;
        System.out.println("sum = " + sum);
        // keypoint 获取路径和是目标值的 数量
        int key = sum - target;
        int count = sumCountMap.getOrDefault(key, 0);

        sumCountMap.put(sum, sumCountMap.getOrDefault(sum, 0) + 1);
        count += downPathSumCount(node.left, target, sum, sumCountMap);
        count += downPathSumCount(node.right, target, sum, sumCountMap);
        sumCountMap.put(sum, sumCountMap.get(sum) - 1);

        return count;
    }


}