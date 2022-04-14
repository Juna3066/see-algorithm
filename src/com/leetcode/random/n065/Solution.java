package com.leetcode.random.n065;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public boolean isNumber(String s) {
        /**
         *
         * ？ 零或者1
         * * 零或者多
         * + 一次或者多次
         * TODO e9 不是 问题没读懂
         */
        String pattern = "([eE]?[-\\+]?[0-9]+)|([-\\+]?[0-9]+.{1}[0-9]+)|([-\\+]?.{1}[0-9]+)|([-\\+]?[0-9]+.{1})";
        Pattern c = Pattern.compile(pattern);
        Matcher m = c.matcher(s);
        return m.find();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("solution = " + solution.isNumber("e9"));

    }
}
