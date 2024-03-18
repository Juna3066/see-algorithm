package com.sword2offer;

import java.util.Stack;

/**
 * @author JUN
 */
public class N37 {
    public static void main(String[] args) {
        N37 n = new N37();
        int[] res = n.asteroidCollision(new int[]{4, 5, -6, 4, 8, -5});
        for (int re : res) {
            System.out.println(re);
        }
    }

    /**
     * 分析入栈出栈的情况,for里 片段顺序 todo
     *
     * @param asteroids
     * @return
     */
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            while (!stack.empty() && stack.peek() > 0 && stack.peek() < -asteroid) {
                stack.pop();
            }
            if (!stack.empty() && asteroid < 0 && asteroid == -stack.peek()) {
                stack.pop();
            } else if (stack.empty() || asteroid > 0 || stack.peek() < 0) {
                stack.push(asteroid);
            }
        }
        return stack.stream().mapToInt(e -> e).toArray();
    }
}