package com.reddy.algotoolbox.week6;

import java.util.*;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
        /**
         * d -> digit array
         * op -> operator array
         * s -> step
         */
        int len = exp.length();
        ArrayList<Integer> d = new ArrayList<>();
        ArrayList<Character> op = new ArrayList<>();

        for (int c = 0; c < len; c++) {
            if(c % 2 == 0){
                d.add(Integer.parseInt(String.valueOf(exp.charAt(c))));
            }else {
                op.add(exp.charAt(c));
            }
        }

        int n = d.size();
        long[][] m = new long[n][n];
        long[][] M = new long[n][n];
        Map<String, Long> minMaxMap = new HashMap<>();
        int j;
        for (int i = 0; i < n; i++) {
            m[i][i] = d.get(i);
            M[i][i] = d.get(i);
        }

        for (int s = 1; s <= n-1; s++) {
            for (int i = 0; i < n-s; i++) {
                j = i + s; // increase i by step
                minMaxMap = getMinAndMax(i, j, op, m, M);
                m[i][j] = minMaxMap.get("min");
                M[i][j] = minMaxMap.get("max");

            }
        }

        return M[0][n-1];
    }

    private static Map<String, Long> getMinAndMax(int i, int j, ArrayList<Character> op, long[][] m, long[][] M){
        /**
         * i -> row, j -> column
         */
        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;
        long a, b, c, d;// set of min and max combinations

        Map<String, Long> minMax = new HashMap<>();

        for (int k = i; k < j; k++) {
            a = eval(M[i][k], M[k+1][j], op.get(k));
            b = eval(M[i][k], m[k+1][j], op.get(k));
            c = eval(m[i][k], M[k+1][j], op.get(k));
            d = eval(m[i][k], m[k+1][j], op.get(k));

            min = mini(min, a, b, c, d);
            max = maxi(max, a, b, c, d);

        }
        minMax.put("min", min);
        minMax.put("max", max);

        return minMax;
    }

    private static long maxi(long max, long a, long b, long c, long d) {
        long[] nums = {max, a, b, c, d};
        Arrays.sort(nums);
        return nums[nums.length-1];
    }

    private static long mini(long min, long a, long b, long c, long d) {
        long[] nums = {min, a, b, c, d};
        Arrays.sort(nums);
        return nums[0];
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

