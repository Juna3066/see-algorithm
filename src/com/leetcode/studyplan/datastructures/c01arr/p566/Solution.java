package com.leetcode.studyplan.datastructures.c01arr.p566;

public class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat[0].length * mat.length != r * c) {
            return mat;
        }

        int[][] res = new int[r][c];
        int cursor = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                res[cursor / c][cursor % c] = mat[i][j];
                cursor++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat =new int[][] {
                {1,2},
                {3,4},
                {5,6}
        };
        int r = 1;
        int c = 6;

        int[][] ints = new Solution().matrixReshape(mat, r, c);
        print2Arr(ints);
    }

    private static void print2Arr(int[][] ints) {
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.print(ints[i][j]+"," );
            }
            System.out.println("");
        }
    }
}
