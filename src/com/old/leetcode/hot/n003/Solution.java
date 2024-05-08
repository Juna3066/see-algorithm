package com.old.leetcode.hot.n003;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {

    /**
     * 突然感觉做题有时候后难点是 输入yong'li
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringC1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)){
                //"abba"
                start = Math.max(map.get(ch)+1,start);
            }
            max = Math.max(max,end - start + 1);
            map.put(ch,end);
        }
        return max;
    }

    public int lengthOfLongestSubstringM1(String s) {
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
//                if (c==s.charAt(i-1)){
//                    //挨着
//                    start = i;
//                }else {
                    //重复的不挨着  下标可以这样理解 0 前面有0个元素，1前面有个一个元素
                    start = start + s.substring(start).indexOf(c) + 1;
//                }

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
        int len = lengthOfLongestSubstringM1("abcood");
        System.out.println("len = " + len);
    }
}
