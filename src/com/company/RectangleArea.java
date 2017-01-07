package com.company;

/**
 * Created by JamesL on 1/6/2017.
 */
public class RectangleArea {
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C-A)*(D-B);
        int area2 = (G-E)*(H-F);
        int overlap = 0;
        int right = Math.min(C,G);
        int left = Math.max(E,A);
        int top = Math.min(D,H);
        int bottom = Math.max(B,F);
        if (right > left && top > bottom) {
            overlap = (right-left)*(top-bottom);
        }
        return area1 + area2 - overlap;
    }
    public static void main(String[] args) {

        System.out.println(computeArea(-2,2,0,2,0,-4,2,2));
    }

}
