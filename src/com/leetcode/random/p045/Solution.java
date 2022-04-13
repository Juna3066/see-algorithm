package com.leetcode.random.p045;

import java.util.Arrays;

public class Solution {
    // {2,3,1,1,4}
    public int jump(int[] nums) {
        int nowIndex = 0;
        int jumpNum = 0;
        while (nowIndex < nums.length -1){
            System.out.println("nowIndex = " + nowIndex + " value = " + nums[nowIndex]);
            int bi =nowIndex + nums[nowIndex];
            if (bi >= nums.length -1 ){
                jumpNum++;
                break;
            }
            int bV = nums[bi];

            int mV = 0;
            int mI = 0;
            for (int i = 1; i < nums[nowIndex]; i++) {
                if (nums[i]>mV){
                    mV = nums[i];
                    mI = i;
                }
            }

            if (mI + mV >  bi + bV){
                nowIndex = mI;
            }else{
                nowIndex = bi;
            }
            jumpNum++;
        }
        return jumpNum;
    }

    public static void main(String[] args) {
        int[] arr = new  int[]{5,9,3,2,1,0,2,3,3,1,0,0};
//        int[] arr = new  int[]{2,3,0,0,3,5,2,9,1,4};
//        int[] arr = new  int[]{4,1,1,3,1,1,1};



        int jump = new Solution().jump(arr);
        System.out.println("jump = " + jump);
    }
}
