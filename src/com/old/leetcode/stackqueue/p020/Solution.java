package com.old.leetcode.stackqueue.p020;

import java.util.Stack;

/**
 * 要么进 要么出
 * 出需要判断，空的话，出不算成功
 * 出不成功，说明匹配也不成功
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> chStack = new Stack<>();

        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c=='(' || c=='[' || c=='{'){
                chStack.push(c);
            }else {
                //第一次错误添加
                if (chStack.isEmpty())
                    return false;
                Character peek = chStack.peek();
                if (peek== '(' && c==')' || peek== '[' && c==']'  || peek== '{' && c=='}' ){
                    chStack.pop();
                }else{
                    //第二次错误添加
                    return false;
                }
            }
        }

        return chStack.isEmpty();
    }

    public static void main(String[] args) {
        //String s = "]";
        String s = "(])";
        boolean valid = new Solution().isValid(s);
        System.out.println("valid = " + valid);
    }

}
