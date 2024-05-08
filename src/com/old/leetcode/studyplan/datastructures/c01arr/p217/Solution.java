package com.old.leetcode.studyplan.datastructures.c01arr.p217;

import java.util.HashSet;

/**
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false
 *
 * 输入：nums = [1,2,3,1]
 * 输出：true
 *
 * nums = [1,2,3,4]
 * 输出：false
 *
 * 输入：nums = [1,1,1,3,3,4,3,2,4,2]
 * 输出：true
 *
 */
public class Solution {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
