package com.reddy.algotoolbox.week6;

import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        //write you code here
        int n = w.length;

        int v[][] = new int[n+1][W+1];

        for (int i = 0; i <= W; i++) {
            v[0][i] = 0;
        }

        for (int j = 1; j <=n ; j++) {
            for (int k = 0; k <=W ; k++) { // k represents weight from 0 to W
                if(w[j-1] <= k){
                    v[j][k] = Math.max(v[j-1][k], w[j-1] + v[j-1][k-w[j-1]]);
                }else {
                    v[j][k] = v[j-1][k]; // just update previous value since that is better as we cannot find anything new
                }
            }
        }
        return v[n][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

