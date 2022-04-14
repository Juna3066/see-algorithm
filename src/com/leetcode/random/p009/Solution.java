package com.leetcode.random.p009;

public class Solution {
    public boolean isPalindrome(int x) {
        String s = x+"";
        char[] chs = s.toCharArray();
        String s2 = "";

        for (int i = chs.length-1;i>=0;i--){
            s2+=chs[i];
        }

        return s.equals(s2);
    }

    public static void main(String[] args) {
        boolean palindrome = new Solution().isPalindrome(0);
        System.out.println("palindrome = " + palindrome);
    }
}
