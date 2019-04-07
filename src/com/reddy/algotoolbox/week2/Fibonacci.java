package com.reddy.algotoolbox.week2;

import java.util.Scanner;

public class Fibonacci {
    private static long calc_fib(int n) {
        if (n <= 1)
            return n;

        return calc_fib(n - 1) + calc_fib(n - 2);
    }

    private static long fib(int n) {
        long [] fibs = new long[n+1];

        fibs[0] = 0;
        if(n > 0)
            fibs[1] = 1;
        for (int i=2; i <= n; i++){
            fibs[i] = fibs[i-1] + fibs[i-2];
        }
        return fibs[n];
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(fib(n));
    }
}
