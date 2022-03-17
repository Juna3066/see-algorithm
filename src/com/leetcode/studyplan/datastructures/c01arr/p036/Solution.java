package com.leetcode.studyplan.datastructures.c01arr.p036;

import java.util.HashSet;

/**
 * 关于每个小方格 和 index 的关系
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        return validRowCol(board) && validCell(board);
    }

    private boolean validCell(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (invalidCell(board, (i % 3) * 3, i / 3 * 3)) return false;
        }
        return true;
    }

    private boolean invalidCell(char[][] board, int iStart, int jStart) {
        HashSet<Character> set = new HashSet<>();
        for (int i = iStart; i < iStart + 3; i++) {
            for (int j = jStart; j < jStart + 3; j++) {
                if ('.' != board[i][j]) {
                    if (set.contains(board[i][j])) {
                        return true;
                    } else {
                        set.add(board[i][j]);
                    }
                }
            }
        }
        return false;
    }

    private boolean validRowCol(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rowSet = new HashSet<>();
            HashSet<Character> colSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if ('.' != board[i][j]) {
                    if (rowSet.contains(board[i][j])) {
                        return false;
                    } else {
                        rowSet.add(board[i][j]);
                    }
                }

                if ('.' != board[j][i]) {
                    if (colSet.contains(board[j][i])) {
                        return false;
                    } else {
                        colSet.add(board[j][i]);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '5', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        boolean validSudoku = new Solution().isValidSudoku(board);
        System.out.println("validSudoku = " + validSudoku);
    }
}
