package com.company;

/**
 * Created by JamesL on 1/10/2017.
 */
public class minproduct {
    public static int multiply(int n, int m) {
        int smaller = (n < m)? n: m;
        int bigger = (n >= m)? n:m;
        int save = smaller;
        smaller = smaller >> 1;

        int result = multiplymin(smaller, bigger, 0);
        int second = result;
        if (save %2 == 1) {
            second += bigger;
        }

        return result + second;
    }

    public static int multiplymin(int smaller, int bigger, int current) {
        if (smaller == 0) {
            return current;
        }
        else {
            current += bigger;
            return multiplymin(smaller-1, bigger, current);
        }
    }

    public static void main(String[] args) {

        System.out.println(multiply(5,6));
        System.out.println(multiply(4,9));
    }
}
