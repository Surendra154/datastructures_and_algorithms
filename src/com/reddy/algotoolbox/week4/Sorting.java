package com.reddy.algotoolbox.week4;

import java.io.*;
import java.util.*;

public class Sorting {
    private static Random random = new Random();

    private static int[] partition3(int[] a, int l, int r) {
      //write your code here

        int m1 = l;
        int m2 = r;


        int x = a[l];

        /**
         * we can implement the code of partition2 twice, then everything has done.
         * First time, we got the left index of the repeated number. At that time, the left array contains the number that is less than the repeated one
         * and the right array contains the numbers that are equal or greater than the repeated one. The second time, we implement the code to the array from the index
         * we get above to the rest, we only need to do a little change to our code that we change the judge statement from less than to equal.
         * After that all the same number will be put on the left. Done.
         */
        for (int i = l + 1; i <= r; i++) {
            if (a[i] < x) {
                m1++;
                m2 = m1;
                int t = a[i];
                a[i] = a[m1];
                a[m1] = t;
            }

        }
        int t = a[l];
        a[l] = a[m1];
        a[m1] = t;

        m2 = m1;
        for (int i = m1 + 1; i <= r ; i++) {
            if (a[i] == x){
                m2++;
                int temp = a[i];
                a[i] = a[m2];
                a[m2] = temp;

            }
        }



        int[] m = {m1, m2};
        return m;
    }

    private static int partition2(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
        return j;
    }


    private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        //use partition3
        int[] m = partition3(a, l, r);
        randomizedQuickSort(a, l, m[0] - 1);
        randomizedQuickSort(a, m[1] + 1, r);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
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

