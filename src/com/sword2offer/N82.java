package com.sword2offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author JUN
 */
public class N82 {
    /**
//     * question 元素可重复数组，不可重复取元素，和是target的集合
     */
    public static void main(String[] args) {
        N82 n = new N82();
        int[] nums = new int[]{2, 2, 2, 4, 3, 3};
        int target = 8;
        List<List<Integer>> combinations = n.combinationSum(nums, target);
        System.out.println("combinations = " + combinations);
    }

    /*
     * keypoint  元素相同，结果会产生重复的集合？如何避免？对nums排序，当决定跳过一个数字的时候，跳过所有的相同数字。
     * 其他的之前组合代码的变体。
     */
    private List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        int index = 0;
        LinkedList<Integer> combination = new LinkedList<>();
        helper(nums, target, index, combination, res);
        return res;
    }

    private void helper(int[] nums, int target, int index, LinkedList<Integer> combination, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new LinkedList<>(combination));
        } else if (target > 0 && index < nums.length) {
            //跳过
            helper(nums, target, getNext(index, nums), combination, res);
            //不跳过
            combination.add(nums[index]);
            helper(nums, target - nums[index], index + 1, combination, res);
            combination.removeLast();
        }
    }

    private int getNext(int index, int[] nums) {
        int cur = index;
        while (cur < nums.length && nums[cur] == nums[index]) {
            cur++;
        }
        return cur;
    }
}
