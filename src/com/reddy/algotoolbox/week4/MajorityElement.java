package com.reddy.algotoolbox.week4;

import java.util.*;
import java.io.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        /**
         * scan through array and keep the count ,
         * if any count > n/2 true else false
         */
        AtomicBoolean isMajorityPresent = new AtomicBoolean(false);
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            if(countMap.containsKey(a[i])){
                countMap.put(a[i], countMap.get(a[i]) + 1);
            }else{
                countMap.put(a[i], 1);
            }
        }

        countMap.forEach((k, v) -> {
            if(v > a.length/2) {
                isMajorityPresent.set(true);
            }
        });

        if(isMajorityPresent.get()){
            return 1;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

