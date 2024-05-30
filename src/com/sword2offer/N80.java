package com.sword2offer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author JUN
 */
public class N80 {
    /**
     * question 面试题80.输入n,k。返回，所有，从1到n中取k个数组成的组合
     */
    public static void main(String[] args) {
        N80 n = new N80();
        List<List<Integer>> combine = n.combine(3, 2);
        for (List<Integer> list : combine) {
            System.out.println(list);
        }
    }

    // keypoint 79的解法上，加了k,子集长度的限制，代码稍作调整。
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        helper(n, k, 1, new LinkedList<>(), result);
        return result;
    }

    private void helper(int n, int k, int i, LinkedList<Integer> combination, List<List<Integer>> result) {
        if (combination.size() == k) {
            result.add(new LinkedList<>(combination));
        } else if (i <= n) {
            helper(n, k, i + 1, combination, result);
            combination.add(i);
            helper(n, k, i + 1, combination, result);
            combination.removeLast();
        }
    }
}
