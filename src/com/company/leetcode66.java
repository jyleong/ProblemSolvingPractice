package com.company;

/**
 * Created by JamesL on 2/23/2017.
 */
public class leetcode66 {

    public static int[] plusOne(int[] digits) {

        int overflow = 0;
        if (digits.length < 1) return digits;
        digits[digits.length-1] = digits[digits.length-1] + 1;
        if (digits[digits.length-1] >= 10) {
            digits[digits.length-1] = 0;
            overflow = 1;
        }

        for (int n= digits.length-2; n >= 0;n--) {
            digits[n] += overflow;
            if (digits[n] >= 10) {
                digits[n] = 0;
                overflow = 1;
            } else {
                overflow = 0;
            }
        }
        if (overflow == 1) {
            int[] newArr = new int[digits.length + 1];
            newArr[0] = 1;
            for (int i = 1; i < newArr.length;i++) {
                newArr[i] = digits[i-1];
            }
            return newArr;
        }
        else return digits;

    }

    public static int[] plusOneBetter(int[] digits) {

        for(int n = digits.length-1;n >=0; n--) {
            if (digits[n] < 9) {
                digits[n]++;
                return digits;
            }
            digits[n] = 0;
        }

        int[] extra = new int[digits.length+1];
        extra[0]++;
        return extra;
    }
}
