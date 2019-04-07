package com.reddy.algotoolbox.week2;

import java.util.*;

public class FibonacciPartialSum {
    private  static ArrayList<Integer> perfibarray = new ArrayList<Integer>();
    private static long getFibonacciPartialSumNaive(long from, long to) {
        long sum = 0;

        long current = 0;
        long next  = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += current;
            }

            long new_current = next;
            next = next + current;
            current = new_current;
        }

        return sum % 10;
    }

    private static long lastSumDigit(long from, long to){


        long pperiod = getpisanoperiod(10);//since last digit modulo 10

        int fnum = (int) (from % pperiod);

        int tnum = (int)(to % pperiod);
        int sum = 0;
        for (int i = fnum ; i <= tnum; i++){
            sum += perfibarray.get(i);
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
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(lastSumDigit(from, to));
    }
}

