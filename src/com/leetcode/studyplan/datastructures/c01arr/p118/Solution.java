package com.leetcode.studyplan.datastructures.c01arr.p118;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row = null;
        for (int i = 0; i < numRows; i++) {
            row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(row);
        }
        return res;
    }


    public static void main(String[] args) {
        List<List<Integer>> generate = new Solution().generate(5);
        printRes(generate);
    }

    private static void printRes(List<List<Integer>> generate) {
        for (List<Integer> list : generate) {
            for (Integer num : list) {
                System.out.print(num+" ");
            }
            System.out.println("");
        }
    }
}
