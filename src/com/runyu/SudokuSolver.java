package com.runyu;

public class SudokuSolver {
    private boolean solved = false;
    private int boxLen = 3;
    private int N = boxLen * boxLen;
    private char[][] board;
    private int[][] rows = new int[N][N + 1];
    private int[][] cols = new int[N][N + 1];
    private int[][] subBoxes = new int[N][N + 1];

    private int getSubBoxIndex(int row, int col) {
        return (row / boxLen) * boxLen + col/boxLen;
    }

    private void placeVal(int row, int col, int val) {
        board[row][col] = (char)(val + '0');
        rows[row][val]++;
        cols[col][val]++;
        int ind = getSubBoxIndex(row, col);
        subBoxes[ind][val]++;
    }

    private void removeVal(int row, int col, int val) {
        board[row][col] = '.';
        rows[row][val]--;
        cols[col][val]--;
        int ind = getSubBoxIndex(row, col);
        subBoxes[ind][val]--;
    }

    private boolean isValid(int row, int col, int val) {
        int ind = getSubBoxIndex(row, col);
        return rows[row][val] + cols[col][val] + subBoxes[ind][val] == 0;
    }

    private void placeOtherVals(int row, int col) {
        if(row == N - 1 && col == N - 1) {
            solved = true;
        } else {
            if(col == N - 1) {
                backtrack(row + 1, 0);
            } else {
                backtrack(row, col + 1);
            }
        }
    }

    private void backtrack(int row, int col) {
        if(board[row][col] == '.') {
            for(int val = 1; val <= N; val++) {
                if(isValid(row, col, val)) {
                    placeVal(row, col, val);
                    placeOtherVals(row, col);
                    if(!solved) {
                        removeVal(row, col, val);
                    }
                }
            }
        } else {
            placeOtherVals(row, col);
        }
    }
    public char[][] solve(char[][] board) {
        this.board = board;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] != '.') {
                    int val = board[i][j] - '0';
                    placeVal(i,j,val);
                }
            }
        }

        backtrack(0, 0);
        return this.board;
    }
}

