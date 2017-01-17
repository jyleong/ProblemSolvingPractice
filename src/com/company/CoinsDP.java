package com.company;

/**
 * Created by JamesL on 1/14/2017.
 */
public class CoinsDP {

    /*
    CTCI CH 8 problem 8.10:
    Given an infnite number of quarters (25 cents), dimes (10 cents), nickels (5 cents), and
    pennies (1 cent), write code to calculate the number of ways of representing n cents.
            */

    //recursion way? doesnt matter combination incorrect
    public static int makeChange(int n) {
        int ways = 0;
        if (n < 0) return ways;
        if (n == 0) {
            ways++;
            return ways;
        }
        ways += makeChange(n - 25) + makeChange(n - 10) + makeChange(n - 5) + makeChange(n - 1);

        return ways;
    }
    // solve with DP

    //Dp array length n + 1
    // Dp[i] = DP[i] + DP[i - coinindex]

    public static int makeChangeDP(int n) {
        int[] DP = new int[n+1];
        DP[0] = 1;
        int[] coins = {1,5,10,25};
        for(int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            for(int j = coin; j < DP.length; j++) {
                DP[j] += DP[j - coin];
            }

        }
        return DP[n];
    }


    public static void main(String[] args) {

        System.out.println("number of ways for 6: should be 2: " + makeChangeDP(6));
        System.out.println("for 25? :" + makeChangeDP(25));
    }
}
