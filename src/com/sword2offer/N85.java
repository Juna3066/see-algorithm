package com.sword2offer;

import java.util.ArrayList;
import java.util.List;


/**
 * @author JUN
 */
public class N85 {
    /**
     * question 输入n，生成匹配的括号字符串,集合
     */
    public static void main(String[] args) {
        N85 n = new N85();
        List<String> res = n.generateParenthesis(3);
        System.out.println("res = " + res);
    }

    /*
     * keypoint 递归中，如何生成，匹配的？ 这个如何用代码实现？
     *
     * 1.问题转化，输入n,即要生成n（ 和 n)，-> 2n 步骤，每步有连个选项（或） 回溯
     * 2.在第任意步骤，想要满足匹配，必须右括号数量，不能超过左括号。
     *
     */
    private List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(n, n, "", res);
        return res;
    }

    private void helper(int leftCount, int rightCount, String parenthesis, List<String> res) {
        if (leftCount == 0 && rightCount == 0) {
            res.add(parenthesis);
        }
        if (leftCount > 0) {
            helper(leftCount - 1, rightCount, parenthesis + "(", res);
        }
        if (leftCount < rightCount) {
            helper(leftCount, rightCount - 1, parenthesis + ")", res);
        }
    }

}
