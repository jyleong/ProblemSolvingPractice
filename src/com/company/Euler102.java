package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by JamesL on 12/31/2016.
 */
public class Euler102 {

    public static int Solution(String filename) {
        int result = 0;
        int[] P = {0,0};
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            String str;

            while ((str = in.readLine()) != null) {
                String[] triCoor = str.split(",");
                int[] A = {Integer.parseInt(triCoor[0]), Integer.parseInt(triCoor[1])};
                int[] B = {Integer.parseInt(triCoor[2]), Integer.parseInt(triCoor[3])};
                int[] C = {Integer.parseInt(triCoor[4]), Integer.parseInt(triCoor[5])};
                int triOne = area(A,B,C);
                int triTwo = area(A,B,P) + area(A,P,C) + area(P,B,C);
                if (comparison(triOne, triTwo)) result++;
            }
            in.close();
        } catch (IOException e) {
            System.out.println("File Read Error");
        }
        return result;
    }
    private static int area(int[] A, int[] B, int[] C) {
        return Math.abs((A[0]-C[0])*(B[1]-A[1]) - (A[0]-B[0])*(C[1]-A[1]));
    }
    private static boolean comparison(int tri1, int tri2) {
        return tri1 == tri2;
    }

    public static void main(String[] args) {
        // write your code here
        int solution = Euler102.Solution("C:\\Users\\JamesL\\Desktop\\p102_triangles.txt");
        System.out.println("number of triangles containing origin: " + solution);
    }
}
