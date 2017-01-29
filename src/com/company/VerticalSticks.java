package com.company;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by JamesL on 1/26/2017.
 */
public class VerticalSticks {

    private static double getExpectedValue(int[] input)
    {
        double result = 0;
        int length = input.length;
        for(int j = 0;j < length; j++) {
            result += (double)(length + 1)/(greaterorequal(input, j) + 1);
        }
        return result;
    }

    private static int greaterorequal(int[] input, int index) {
        int match = input[index];
        int count = 0;
        for(int i = 0; i < input.length; i++) {
            if (input[i] >= match) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int no_cases = scanner.nextInt();
        for (int i = 0; i < no_cases; i++) {
            int n = scanner.nextInt();
            int[] input = new int[n];
            for(int j = 0; j < n; j++) {
                input[j] = scanner.nextInt();
            }
            System.out.printf("%.2f\n", getExpectedValue(input));
        }
    }
}
