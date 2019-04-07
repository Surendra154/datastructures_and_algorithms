package com.reddy.algotoolbox.week4;

import java.io.*;
import java.util.*;

public class BinarySearch {

    public static int binarySearch(int[] a,int low, int high, int key) {
       // int left = 0, right = a.length;
        //write your code here
       int mid = low + (high - low) / 2;
        //int mid = (low + high)  / 2;
        if(low <= high){
            if(a[mid] == key){
                return mid;
            }
            if(a[mid] < key){
                return binarySearch(a, mid+1, high, key);
            }
            return binarySearch(a, low, mid-1, key);
        }

        return -1;
    }

    public static int binarySearchIter(int[] a,int low, int high, int key) {
        // int left = 0, right = a.length;
        //write your code here

        while(low <= high){
            int mid = low +( (high - low) / 2);
           // System.out.println(mid);
            if(a[mid] == key){
                return mid;
            }else if(a[mid] < key){
                low = mid+ 1;
            }else {
                high = mid-1;
            }
        }

        return -1;
    }

    public static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
          b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            //replace with the call to binarySearch when implemented
            System.out.print(binarySearchIter(a, 0,  b.length-1,b[i]) + " ");
            System.out.print(linearSearch(a, b[i]) + " ");
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
