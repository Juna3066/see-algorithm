package com.sword2offer;

import java.util.LinkedList;
import java.util.List;


/**
 * @author JUN
 */
public class N83 {

    /**
     * question 面试题83.没有重复元素集合，的全排列
     */
    public static void main(String[] args) {
        N83 n = new N83();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> result = n.permute(nums);
        System.out.println("result = " + result);
    }

    /*
     * keypoint 1.排列，和元素顺序有关。2.元素顺序交换，会产生新的排列。3.生成全排列的过程，就是集合中的元素，置换位置的过程。
     */
    private List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        int index = 0;
        helper(nums, index, res);
        return res;
    }

    private void helper(int[] nums, int index, List<List<Integer>> res) {
        if (index == nums.length) {
            LinkedList<Integer> permutation = new LinkedList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            res.add(permutation);
//        } else if (index < nums.length) {
        } else {
            //获取全排列，就是置换元素顺序的过程。
            for (int i = index; i < nums.length; i++) {
                //index位置的元素可以是，index以及后面的元素
                swap(index, i, nums);
                helper(nums, index + 1, res);
                //取消影响
                swap(index, i, nums);
            }
        }
    }

    private void swap(int index, int i, int[] nums) {
        int temp = nums[index];
        nums[index] = nums[i];
        nums[i] = temp;
    }
}
