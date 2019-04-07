package com.reddy.algotoolbox.week5;

import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }

    /**
     * bottom up approach
     * @param n
     * @return
     */
    private static List<Integer> optimal_sequenceDP(int n) {
        List<Integer> sequence = new ArrayList<Integer>();

        int[] arr = new int[n + 1];

        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i-1] + 1;

            if(i% 2 == 0){
                arr[i] = Math.min(arr[i], 1 + arr[i/2]);
            }

            if(i%3 == 0){
                arr[i] = Math.min(arr[i],1 + arr[i/3]);
            }
        }

        int i = n;
        while (i>=1) {
            sequence.add(i);
            if (arr[i-1] == arr[i]-1)
                i = i-1;
            else if (i%2 == 0 && (arr[i/2] == arr[i]-1))
                i = i/2;
            else if (i%3 == 0 && (arr[i/3] == arr[i]-1))
                i = i/3;
        }
       // sequence.add(1);
        Collections.reverse(sequence);
        return sequence;
    }

    private static int min(int a, int b, int c){
        if(a < b && a <c){
            return a;
        }else if(b < c){
            return b;
        }

        return c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequenceDP(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }

        //System.out.println(optimal_sequenceDP(n));
    }
}

