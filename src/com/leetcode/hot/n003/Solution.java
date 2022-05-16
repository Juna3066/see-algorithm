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
                    System.out.println(start + 1);
                    maxLen = set.size();
                }
                set.clear();
                start = s.substring(start).indexOf(c);
                char[] chs = s.substring(start+1, i + 1).toCharArray();
                for (char ch : chs) {
                    set.add(ch);
                }
            }
        }
        return maxLen > set.size() ? maxLen : set.size();
    }

    @Test
    public void test() {
//        int len = lengthOfLongestSubstring(" ");
        int len = lengthOfLongestSubstring("pwwkew");
        System.out.println("len = " + len);
    }
}
