package com.leetcode.hot.n215;

public class Solution {

    //交换排序 冒泡排序   插入排序
    public int findKthLargestM1(int[] nums, int k) {
        for (int i = 0; i < nums.length -1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]<nums[j]){
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
            }
        }
        return nums[k-1];
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        int kthLargest = new Solution().findKthLargestM1(nums, k);
        System.out.println(kthLargest);
    }

}
