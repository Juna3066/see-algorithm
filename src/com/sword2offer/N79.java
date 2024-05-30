package com.sword2offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author JUN
 */
public class N79 {
    /**
     * question 面试题79：输入不重复元素的数组，输出所有子集
     */
    public static void main(String[] args) {
        int[] nums = {1, 2};
        N79 n = new N79();
        List<List<Integer>> subsets = n.subsets(nums);
        System.out.println("subsets = " + subsets);
    }

    /*
     * keypoint 不会，数组的for和dfs如何组合？
     * 递归方法中，用参数nums,index表示数组取元素
     *
     * 时间复杂度 O(2^n)
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return subsets;
        }
        int index = 0;
        LinkedList<Integer> subset = new LinkedList<>();
        helper(nums, index, subset, subsets);
        return subsets;
    }

    //下单行注释的代码，是常见的错误写法
    private void helper(int[] nums, int index, LinkedList<Integer> subset, List<List<Integer>> subsets) {
        if (index == nums.length) {
            subsets.add(new LinkedList<>(subset));
//        }else {
        } else if (index < nums.length) {
//            helper(nums, index++, subset, subsets);
            //当前元素不添加
            helper(nums, index + 1, subset, subsets);
            //当前元素添加
            subset.add(nums[index]);
//            helper(nums, index++, subset, subsets);
            helper(nums, index + 1, subset, subsets);
            //移除添加元素的影响
            subset.removeLast();
        }
    }

}
