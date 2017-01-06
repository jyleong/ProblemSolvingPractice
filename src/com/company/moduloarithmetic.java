package com.company;

/**
 * Created by JamesL on 1/4/2017.
 */
public class moduloarithmetic {

    private static int modroutine(String a, int m) {
        int result = 0;
        for(int i = 0, n = a.length(); i < n; i++) {
            result = result * 10 + Integer.parseInt(a.charAt(i) + "");
            result %= m;
        }
        return result;
    }

    private static int appExponent(String a, int b, int m) {
        int answer = modroutine(a, m);
        int current = answer;
        for(int i = 1; i < b; i++) {
            answer = (answer * current) % m;
        }

        return answer;
    }

    public static void main(String[] args) {
        // write your code here
        String a = "987584345091051645734583954832576";
        int b = 3, m = 11;
        System.out.println(appExponent(a,b,m));
    }
}
