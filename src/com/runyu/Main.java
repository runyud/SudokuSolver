package com.runyu;

public class Main {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'.','.','5','8','1','.','6','.','3'},
                {'.','9','.','.','.','.','.','.','2'},
                {'.','.','.','.','.','3','.','.','.'},
                {'5','.','.','.','.','.','.','8','.'},
                {'.','.','8','6','7','.','1','.','.'},
                {'.','.','.','4','.','.','.','.','.'},
                {'.','.','7','.','.','4','.','.','.'},
                {'2','.','.','7','3','.','.','.','6'},
                {'.','.','.','.','.','5','3','.','.'}};

        SudokuSolver solver = new SudokuSolver();
        char[][] answer = solver.solve(board);
        for(char[] row : answer) {
            for(char elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

}
