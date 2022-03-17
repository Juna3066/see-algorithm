package com.leetcode.studyplan.datastructures.c01arr.p121;

public class Solution {
    public int maxProfit(int[] prices) {
        int max=0,dp=0,num=0;
        for (int i = 1; i < prices.length; i++) {
            num = prices[i]- prices[i-1];
            dp = Math.max(dp+num,num);
            max = Math.max(max,dp);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
//        int[] prices = {7,6,4,3,1};
//        int[] prices = {1,2};
        int i = new Solution().maxProfit(prices);
        System.out.println("i = " + i);
    }
}
