package com.old.leetcode.random.p704;

/**
 [-1,0,3,5,9,12]
 13
 */
class Solution {
    public int search(int[] nums, int target) {
        //4.传的是数组下表
        return search(nums, target, 0, nums.length-1);
    }

    public int search(int[] nums, int target, int start, int end) {
        //3.未找到条件之1
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        int midVal = nums[mid];
        //2.返回下表
        if (midVal == target) {
            return mid;
        }
        //1.递归
        return midVal > target ? search(nums, target, start, --mid) : search(nums, target, ++mid, end);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};
        int target = 13;
        int search = new Solution().search(nums, target);
        System.out.println("search = " + search);
    }
}