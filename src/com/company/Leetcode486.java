package com.company;

/**
 * Created by JamesL on 2/13/2017.
 */
public class Leetcode486 {
    /* problem 486 Predict the winner */
    /* solved recursively with idea from minimax algorithm */
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length < 1) return false;
        int totalSum = 0;
        for(int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        int play1Sum = sumMax(nums, 0, nums.length-1);
        int play2Sum = totalSum - play1Sum;
        return play1Sum >= play2Sum;
    }

    public int sumMax(int[] nums, int start, int end) {
        if (start > end) return 0;
        int first = nums[start] + Math.min(sumMax(nums, start+2, end), sumMax(nums, start+1, end -1));
        int last = nums[end] + Math.min(sumMax(nums, start, end-2), sumMax(nums, start+1, end -1));

        return Math.max(first, last);
    }
}
