package com.leetcode.random.p045;

import java.util.Arrays;

public class Solution {
    //[3,3,5,1,4]
    public int jump(int[] nums) {
        int nowIndex = 0;
        int jumpNum = 0;
//        while (nowIndex < nums.length -1){
//            if (nowIndex+nums[nowIndex] > nums.length -1){
//                nowIndex++;
//            }else{
//                nowIndex += nums[nowIndex];
//            }
//            jumpNum++;
//        }
        return jumpNum;
    }

    public static void main(String[] args) {
        int[] arr = new  int[]{2,3,1,1,4};
        int jump = new Solution().jump(arr);
        System.out.println("jump = " + jump);
    }
}
