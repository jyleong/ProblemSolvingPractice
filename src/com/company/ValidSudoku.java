package com.company;

/**
 * Created by JamesL on 2/5/2017.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) return false;

        for(int i = 0; i < 9; i ++) {
            for(int j = 0; j < 9; j++) {
                if (!isValid(board, i, j)) return false;
            }
        }
        return true;
    }

    public boolean isValid(char[][]board, int i, int j) {
        if (board[i][j] == '.') return true;
        // look at row
        for (int t = 0; t < 9; t++) {
            if (board[i][t] == board[i][j] && t != j) return false;
        }
        //look at column
        for (int t = 0; t < 9; t++) {
            if (board[t][j] == board[i][j] && t != i) return false;
        }
        // look inside a box
        for (int t = 0; t < 3; t++) {
            for(int y = 0; y < 3; y++) {
                int a = i/3 * 3+ t;
                int b = j/3 * 3 + y;
                if (board[a][b] == board[i][j] && a != i && b != j) return false;
            }
        }
        return true;

    }
}
