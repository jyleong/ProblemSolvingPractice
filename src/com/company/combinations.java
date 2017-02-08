package com.company;
import java.util.*;

/**
 * Created by JamesL on 2/7/2017.
 */

/* solution to Leetcode problem 77. */
public class combinations {

    /* take an n and k
    return list combinations for nCk otherwise the k number of combinations of 1 to n
    return as a list of lists
    * */
    public List<List<Integer>> combine(int n, int k) {
        if (n == k || k == 0) {
            List<Integer> res = new ArrayList<Integer>();
            for(int i = 1; i <= k; i++) {
                res.add(i);
            }
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            result.add(res);
            return result;
        }
        else {
            List<List<Integer>> result = this.combine(n-1,k-1);
            for (List<Integer> r: result) {
                r.add(n);
            }
            result.addAll(this.combine(n-1,k));
            return result;
        }
    }
}
