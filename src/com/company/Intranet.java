package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by JamesL on 3/24/2017.
 */

/*
* Google code jam problem practice 2010 problem A
* https://code.google.com/codejam/contest/619102/dashboard
* */

public class Intranet {
    public static final String WELCOME = "welcome to code jam";

    public static void Solution(String filename) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
            String numTestCase = in.readLine();
            int numTests = Integer.parseInt(numTestCase);
            int testCases = 0;
            while(testCases < numTests) {
                int numWires  = Integer.parseInt(in.readLine());
                int i = 0;
                ArrayList<int[]> listTuples = new ArrayList<int[]>();
                while(i < numWires) {
                    String[] line = in.readLine().split(" ");
                    int A = Integer.parseInt(line[0]);
                    int B = Integer.parseInt(line[1]);
                    int[] tuple = {A,B};
                    listTuples.add(tuple);
                    i++;
                }
                testCases++;
                int result = findNumIntersections(listTuples);
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

    public static int findNumIntersections(ArrayList<int[]> listTuples) {
        int count = 0;
        ArrayList<int[]> visitedList = new ArrayList<int[]>();
        visitedList.add(listTuples.get(0));
        for (int j = 1; j < listTuples.size(); j++) {
            int[] current = listTuples.get(j);
            for (int[] visited : visitedList) {
                if ((current[0] < visited[0] && current[1] > visited[1]) ||
                        (current[0] > visited[0] && current[1] < visited[1])) {
                    count++;
                }
            }
            visitedList.add(current);
        }
        return count;
    }

    public static void main(String[] args) {
        // write your code here
        Intranet.Solution("C:\\Users\\JamesL\\Downloads\\A-large-practice.in");

    }
}
