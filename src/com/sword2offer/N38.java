package com.sword2offer;

import java.util.Stack;

/**
 * @author JUN
 */
public class N38 {
    public static void main(String[] args) {
        N38 n = new N38();
        int[] res = n.dailyTemperatures(new int[]{35, 31, 33, 36, 34});
        for (int re : res) {
            System.out.println(re);
        }
    }

    /**
     * 定义递减温度栈解决问题。
     *
     * 栈顶和当前元素比较，[不符合 当前元素 小于等于 栈顶元素] .
     * 栈顶出，并计算结果。重复步骤，知道可以当前元素可入栈。
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures){
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                Integer prev = stack.pop();
                res[prev] = i - prev;
            }
            stack.push(i);
        }

        return res;
    }
}
