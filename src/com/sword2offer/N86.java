package com.sword2offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author JUN
 */
public class N86 {
    /**
     * question 面试题86 分割成回文子字符串。
     */
    public static void main(String[] args) {
        N86 n = new N86();
        String str = "google";
        List<List<String>> res = n.partition(str);
        System.out.println("res = " + res);
    }

    private List<List<String>> partition(String str) {
        List<List<String>> res = new ArrayList<>();
        helper(str, 0, new LinkedList<>(), res);
        return res;
    }

    /*
     * keypoint 分割,成回文，用代码如何表示？解决这个问题的步骤？
     * google
     * 处理到第一个g,有6中分隔法，逐个判断，如果是回文，可继续分隔。
     * g           是回文，可继续
     *              o,
     *              oo,         是回文，可继续
     *                  g,l,e
     *              oog
     *              oogl
     *              oogle
     * go,
     * goo
     * goog         是回文，可继续
     *              g,l,e
     * googl
     * google
     *
     */
    private void helper(String str, int start, LinkedList<String> substrings, List<List<String>> res) {
        if (start == str.length()) {
            res.add(new LinkedList<>(substrings));
        } else {
            for (int cur = start; cur < str.length(); cur++) {
                if (isPalindrome(str, start, cur)) {
                    // keypoint str.charAt(start)...str.charAt(end-1)
                    substrings.add(str.substring(start, cur + 1));
                    helper(str, cur + 1, substrings, res);
                    substrings.removeLast();
                }
            }
        }
    }

    private boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

}
