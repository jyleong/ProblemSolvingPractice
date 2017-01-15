package com.company;

/**
 * Created by JamesL on 1/15/2017.
 */

/*
*Tableau Question:
You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B. Write a method to merge B into A in sorted order.
Give your time and space complexity.

Algorithm idea, since A is larger enough to hold entire result somehow sort in place
sort by looking at the end of each array instead of the start, compare for the greatest value
and put that at the end of A, this way no problem overwriting values of A and no need for external memory
linear time linear space
* */
public class sortedmergespace {

    public static int[] sortMerge(int[] A, int B[], int aSize, int bSize) {
        int aIndex = aSize, bIndex = bSize;
        int index = A.length-1;
        while (aIndex >= 0 && bIndex >= 0) {
            A[index--] = (A[aIndex] >= B[bIndex]) ? A[aIndex--] : B[bIndex--];
        }
        while (aIndex >= 0) {
            A[index--] = A[aIndex--];
        }
        while (bIndex >= 0) {
            A[index--] = B[bIndex--];
        }
        return A;
    }

    public static void main(String[] args) {

        int[] first = {1,4,5,7,9,0,0,0,0,0};
        int[] second = {2,3,5,7,10};

        int[] result = sortMerge(first, second, 4, 4);
        for(int j = 0; j < result.length; j++) {
            System.out.println(result[j]);

        }
    }
}
