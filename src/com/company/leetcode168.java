package com.company;

/**
 * Created by JamesL on 1/9/2017.
 */
public class leetcode168 {

    public static String convertToTitle(int n) {
        String solution = "";
        while(n > 0) {
            n--;
            solution = (char) ('A' + n%26) + solution;
            n/=26;
        }

        return solution;
    }

    public static void main(String[] args) {

        for(int i = 0; i < 50; i++) {
            int random = (int) (Math.random()*4000 + 1);
            System.out.println("Test case " + (i+1) + ":"  + random + " is "+ convertToTitle(random));
        }
    }
}
