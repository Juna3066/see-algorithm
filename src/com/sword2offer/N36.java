package com.sword2offer;

import java.util.Stack;

/**
 * 后缀表达式又叫逆波兰表达式，把操作符号，放在操作数后面的表达式。
 * 1+2*3 的RPN是 123*+
 * (1+2)*3 的RPN是 12+3*
 *
 * 代码封装函数 是有好处的， 公共代码错了，我只用该一个地方。比如28,29顺序错了。互换一下这两行就行了。
 * @author JUN
 */
public class N36 {
    public static void main(String[] args) {
        N36 n = new N36();
        int i = n.evalRPN(new String[]{"2", "1", "3", "*", "+"});
        System.out.println("i = " + i);
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/":
                    Integer n = stack.pop();
                    Integer m = stack.pop();
                    Integer res = cal(m, n, token);
                    stack.push(res);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }

    private Integer cal(Integer m, Integer n, String token) {
        switch (token) {
            case "+":
                return m + n;
            case "-":
                return m - n;

            case "*":
                return m * n;
            case "/":
                return m / n;
            default:
                return 0;
        }
    }
}
