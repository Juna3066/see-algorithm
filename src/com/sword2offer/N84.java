package com.sword2offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author JUN
 */
public class N84 {
    /**
     * question 面试题84，重复元素的集合的全排列
     */
    public static void main(String[] args) {
        N84 n = new N84();
        int[] nums = new int[]{1, 1, 2};
        List<List<Integer>> res = n.permute(nums);
        System.out.println("res = " + res);
    }

    /*
     * keypoint 相同的元素，交换位置，是同一个排列。所以判断是相同的元素，跳过交换
     */
    private List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, res);
        return res;
    }

    private void helper(int[] nums, int i, List<List<Integer>> res) {
        if (i == nums.length) {
            ArrayList<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            res.add(permutation);
        } else {
            //6次 keypoint set用来存储 和i位置交换的数字，如果之前已经存在相同的数字交换过，那么跳过交换。
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                if (!set.contains(nums[j])) {
                    set.add(nums[j]);
                    swap(i, j, nums);
                    helper(nums, i + 1, res);
                    swap(i, j, nums);
                } else {
                    System.out.println("jump swap j = " + j);
                }
            }
        }
    }

    private void swap(int index, int i, int[] nums) {
        int temp = nums[index];
        nums[index] = nums[i];
        nums[i] = temp;
    }


}
