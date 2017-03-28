package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by JamesL on 3/24/2017.
 */

/*
* Google code jam problem practice 2009 problem C
* https://code.google.com/codejam/contest/90101/dashboard#s=p2
* */

public class welcometocodejam {
    public static final String WELCOME = "welcome to code jam";

    public static void Solution(String filename) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
            String numTestCase = in.readLine();
            int numTests = Integer.parseInt(numTestCase);
            int testCases = 0;
            while(testCases < numTests) {
                String line = in.readLine();
                int result = occurence(line);
                System.out.println("test string: " + line);
                System.out.println("matches: " + result);
                testCases++;
                writer.println("Case #" + testCases + ": " + String.format("%04d",result));
            }
            in.close();
            writer.close();
        }
        catch (IOException e) {
            System.out.println("File Read Error");
            e.printStackTrace();
        }
    }

    public static int occurence(String input) {
        int[][] DP = new int[WELCOME.length()+1][input.length()+1];
        DP[0][0] = 1;
        for(int t = 0; t < input.length()+1; t++) {
            DP[0][t] = 1;
        }
        for(int i = 0; i < WELCOME.length(); i++) {
            for(int j = 0; j < input.length(); j++) {
                if (WELCOME.charAt(i) == input.charAt(j)) {
                    DP[i+1][j+1] = (DP[i+1][j] + DP[i][j+1])%10000;
                }
                else {
                    DP[i+1][j+1] = DP[i+1][j];
                }
            }
        }
        return DP[WELCOME.length()][input.length()];
    }

    public static void main(String[] args) {
        // write your code here
        welcometocodejam.Solution("C:\\Users\\JamesL\\Downloads\\C-large-practice.in");

    }
}
