package com.reddy.algotoolbox.week2;

import java.util.*;

public class FibonacciSumSquares {
    private  static ArrayList<Integer> perfibarray = new ArrayList<Integer>();

    private static long getFibonacciSumSquaresNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current * current;
        }

        return sum % 10;
    }

    private static long lastSqSumDigit(long n){
        if (n == 0 || n == 1)
            return n;

        long pperiod = getpisanoperiod(10);//since last digit modulo 10

        int num = (int) (n % pperiod);
        int sum = 0;
        for (int i = 0 ; i <= num; i++){
            sum += Math.pow(perfibarray.get(i), 2);
        }
        return sum%10;
    }

    private static long getpisanoperiod(long m) {

        perfibarray.add(0);
        perfibarray.add(1);
        int count = 0;

        int first = 0;
        int second = 1;
        while(!(count > 0 && perfibarray.get(count) == 0 && perfibarray.get(count+ 1) == 1)){

            perfibarray.add((int) ((perfibarray.get(count) % m + perfibarray.get(count+ 1) % m) % m));

            count++;
        }

//        int sum =0;
//        for (int i=0; i< perfibarray.size(); i++){
//            sum += perfibarray.get(i);
//        }
        //      sum = sum -1;//since first 0, 1 counts to 1
        // System.out.println(sum %10); modulo of sum of 60 period i zero
        return (long) count;

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = lastSqSumDigit(n);
        System.out.println(s);
    }
}

