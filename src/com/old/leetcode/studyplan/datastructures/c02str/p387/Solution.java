package com.old.leetcode.studyplan.datastructures.c02str.p387;

public class Solution {
    public int firstUniqChar(String s) {

        int[] word = new int[26];
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            word[chs[i] - 97]++;
        }

        for (int i = 0; i < chs.length; i++) {
            if (word[chs[i] - 97] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        int i = new Solution().firstUniqChar(s);
        System.out.println(i);
    }
}
