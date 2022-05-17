package com.leetcode.hot.n003;

import org.junit.Test;

import java.util.HashSet;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, maxLen = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.isEmpty() || !set.contains(c)) {
                set.add(c);
            } else {
                if (set.size() > maxLen) {
                    maxLen = set.size();
                }
                set.clear();
                //这个开始的坐标移动是一个难点
                if (c==s.charAt(i-1)){
                    //挨着
                    start = i;
                }else {
                    //重复的不挨着
                    start = start + s.substring(start).indexOf(c) + 1;
                }

                char[] chs = s.substring(start, i + 1).toCharArray();
                for (char ch : chs) {
                    set.add(ch);
                }
            }
        }
        return maxLen > set.size() ? maxLen : set.size();
    }

    @Test
    public void test() {
        int len = lengthOfLongestSubstring("obovodc");
        System.out.println("len = " + len);
    }
}
