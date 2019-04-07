package com.reddy.algotoolbox.week2;

import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % 10;
    }

    private static int getFibLastDiggy(int n) {
        int [] fibs = new int[n+1];
        fibs[0] = 0;
        if(n > 0)
            fibs[1] = 1;

        for (int i=2; i <= n; i++){
            fibs[i] = (fibs[i-1] + fibs[i-2]) % 10 ;
        }
        return fibs[n];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibLastDiggy(n);
        System.out.println(c);
    }
}

