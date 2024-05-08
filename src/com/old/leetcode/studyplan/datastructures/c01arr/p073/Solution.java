package com.old.leetcode.studyplan.datastructures.c01arr.p073;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        for (Integer row : rowSet) {
            for (int col = 0; col < n; col++) {
                matrix[row][col] = 0;
            }
        }

        for (Integer col : colSet) {
            for (int row = 0; row < m; row++) {
                matrix[row][col] = 0;
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 0, 5},
                {4, 3, 1, 4},
                {0, 1, 1, 4},
                {1, 2, 1, 3},
                {0, 0, 1, 1}
        };
        new Solution().setZeroes(matrix);
    }
}
