package com.company;

/**
 * Created by JamesL on 1/17/2017.
 */
public class SpiralMatrix {


    /*

    Leetcode problem 59. Spiral Matrix II
    "Given an integer n, generate a square matrix filled with elements 1 to n^2 in spiral order"
    * Accepted solution, runs in O(n) time?
    * possibly write more test cases to extende,
    * */
    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int num = 1;
        int rowStart = 0;
        int rowEnd = n-1;
        int colStart = 0;
        int colEnd = n-1;
        int i;
        while(rowStart <= rowEnd && colStart <= colEnd) {
            for(i = colStart; i <= colEnd; i++) {
                result[rowStart][i] = num++;
            }
            rowStart++;
            for(i = rowStart; i <= rowEnd; i++) {
                result[i][colEnd] = num++;
            }
            colEnd--;
            for(i = colEnd; i >= colStart; i--) {
                result[rowEnd][i] = num++;
            }
            rowEnd--;
            for(i = rowEnd; i >= rowStart; i--) {
                result[i][colStart] = num++;
            }
            colStart++;

        }
        return result;

    }

    public static void main(String[] args) {

        int[][] test = generateMatrix(4);
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                System.out.print(test[i][j] + " ");
            }
            System.out.println();
        }
    }
}
