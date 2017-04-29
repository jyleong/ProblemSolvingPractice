package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by JamesL on 4/28/2017.
 * Solution to Google codejam load test
 * https://code.google.com/codejam/contest/619102/dashboard#s=p1
 */
public class LoadTest {

    public static void Solution(String filename) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
            String numTestCase = in.readLine();
            int numTests = Integer.parseInt(numTestCase);
            int testCases = 0;
            while(testCases < numTests) {
                String[] line = in.readLine().split(" ");
                int L = Integer.parseInt(line[0]);
                int P = Integer.parseInt(line[1]);
                int C = Integer.parseInt(line[2]);

                testCases++;
                int result = findNumber(L,P,C);
                System.out.println("Case #" + testCases + ": " + result);
                writer.println("Case #" + testCases + ": " + result);
            }
            in.close();
            writer.close();
        }
        catch (IOException e) {
            System.out.println("File Read Error");
            e.printStackTrace();
        }
    }

    public static int findNumber(int L, int P, int C) {

        int answer = 0;

        while(true) {
            if (L * Math.pow(C, Math.pow(2,answer)) >= P) {
                return answer;
            }
            answer++;
        }
    }
}
