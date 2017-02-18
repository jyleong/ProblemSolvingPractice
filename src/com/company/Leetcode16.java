package com.company;

import java.util.Arrays;

/**
 * Created by JamesL on 2/14/2017.
 */
public class Leetcode16 {

    /* Leetcode problem 16. 3Sum Closest
    Given an array S of n integers, find three integers in S such that the
    sum is closest to a given number, target. Return the sum of the three integers.
    You may assume that each input would have exactly one solution.
     */

    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length];
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            int start = i+1;
            int end = nums.length-1;
            while(start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if (sum > target) {end--;}
                else if (sum <= target) {start++;}

                if (Math.abs(target - sum) < Math.abs(target - result)) {
                    result = sum;
                }
            }
        }
        return result;
    }
}
