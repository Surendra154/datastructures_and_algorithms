package com.reddy.algotoolbox.week2;

import java.util.*;

public class FibonacciHuge {

    private  static ArrayList<Integer> perfibarray = new ArrayList<Integer>();
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }

    private static long getFibbyHugeMod(long n, long m){
        if (n <= 1)
            return n;

        long pperiod = getpisanoperiod(m);
       // System.out.println(pperiod);
        return perfibarray.get((int)(n % pperiod));
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
        //System.out.println(perfibarray.toString());
        return (long) count;

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibbyHugeMod(n, m));
    }
}

