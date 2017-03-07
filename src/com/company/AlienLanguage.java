package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.*;

/**
 * Created by JamesL on 2/25/2017.
 */
/*Google code jam problem A: Alien Language
https://code.google.com/codejam/contest/90101/dashboard#s=p0
* */
public class AlienLanguage {
    /* solution bruteforce with regular expressions*/
    public static void SolutionRegex(String filename) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            PrintWriter writer = new PrintWriter("output.txt", "UTF-8");

            String[] params = in.readLine().split(" ");
            int L = Integer.parseInt(params[0]);
            int D = Integer.parseInt(params[1]);
            int N = Integer.parseInt(params[2]);
            int c = 0;
            ArrayList<String> words = new ArrayList<String>();
            ArrayList<Pattern> patterns = new ArrayList<Pattern>();
            /* read words to mapping*/
            while(c < D) {
                words.add(in.readLine());
                c++;
            }
            c = 0;
            while(c < N) {
                Pattern p = Pattern.compile(in.readLine().replace("(","[").replace(")","]"));
                patterns.add(p);
                c++;
            }
            /* read patterns to regex list*/
            int testCase = 0;
            for (Pattern p: patterns) {
                testCase++;
                int count = 0 ;
                for (String s: words) {
                    Matcher m = p.matcher(s);
                    if (m.matches()) {
                        count++;
                    }
                }
                writer.println("Case #" + testCase + ": " + count);
            }

            in.close();
            writer.close();
        } catch (IOException e) {
            System.out.println("File Read Error");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // write your code here
        AlienLanguage.SolutionRegex("C:\\Users\\JamesL\\Desktop\\A-Large-practice.in");

    }

}
