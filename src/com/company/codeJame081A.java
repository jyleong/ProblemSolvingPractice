package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.math.BigInteger;

/**
 * Created by JamesL on 1/2/2017.
 */
public class codeJame081A {
    public static void Solution(String filename) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
            String str;
            str = in.readLine();
            int testCases = Integer.parseInt(str);
            int count = 0;
            while (count < testCases) {
                //for each case, read three lines
                int length = 0;
                String input1 = null;
                String input2= null;
                if ((str = in.readLine()) != null) {
                    length = Integer.parseInt(str);
                }
                if ((str = in.readLine()) != null) {
                    input1 = str;
                }
                if ((str = in.readLine()) != null) {
                    input2 = str;
                }
                //preprocessing array to calculate on
                String[] xArr = input1.split(" ");
                String[] yArr = input2.split(" ");

                int[] iXArr = new int[length];
                int[] iYArr = new int[length];

                for(int i = 0;i < length;i++) {
                    iXArr[i] = Integer.parseInt(xArr[i]);
                    iYArr[i] = Integer.parseInt(yArr[i]);
                }
                //solution fucntion for dp here
                int testCaseAns = DP(iXArr, iYArr, length);
                int caseNum = count+1;
                System.out.println("Case #" + caseNum + ": " + testCaseAns);
                writer.println("Case #" + caseNum + ": " + testCaseAns);
                count++;

            }
            in.close();
            writer.close();
        } catch (IOException e) {
            System.out.println("File Read Error");
            e.printStackTrace();
        }
    }

    private static int DP(int[] A, int[] B, int length) {
        int[][] result = new int[length+1][length+1];
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[i].length; j++) {
                result[i][j] = A[i-1]*B[j-1] + Math.min(result[i-1][j], result[i][j-1]);
            }
        }
        return result[length][length];
    }

    public static void main(String[] args) {
        // write your code here
        codeJame081A.Solution("C:\\Users\\JamesL\\Desktop\\A-small-practice.in");

    }
}
