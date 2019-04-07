package com.reddy.algotoolbox.week4;

import java.util.Arrays;
import java.util.Scanner;

public class PointsAndSegments {
    static int length;
    private static class Segment implements Comparable<Segment>{

        int value;
        String marker;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getMarker() {
            return marker;
        }

        public void setMarker(String marker) {
            this.marker = marker;
        }

        /**
         * (2, l) , (3, p), (5, r) -> l x-intercept , p is point , r is y-intercept
         * @param value
         * @param marker
         */
        Segment(int value, String marker) {
            this.value = value;
            this.marker = marker;
        }

        @Override
        public String toString() {
            return "value : " + value + " marker : " + marker ;
        }

        @Override
        public int compareTo(Segment o) {
            if(value < o.value){
                return -1;
            } else if(value > o.value){
                    return 1;
            }else {
                return 0;
            }
        }
    }

    public static int binarySearchIterCountLeft(Segment[] segments,int low, int high, int key) {
        // int left = 0, right = a.length;
        //write your code here
        int count = 0;
        while(low <= high){
            int mid = low +( (high - low) / 2);
            // System.out.println(mid);
            if(segments[mid].getValue() == key){
                for (int i = 0; i <= mid ; i++) {
                    if(segments[i].getMarker().equals("l")){
                        count++;
                    }
                }
                return count;
            }else if(segments[mid].getValue() < key){
                low = mid+ 1;
            }else {
                high = mid-1;
            }
        }

        return count;
    }

    public static int binarySearchIterCountRight(Segment[] segments,int low, int high, int key) {
        // int left = 0, right = a.length;
        //write your code here
        int count = 0;
        int end = high;
        while(low <= high){
            int mid = low +( (high - low) / 2);
            // System.out.println(mid);
            if(segments[mid].getValue() == key){
                for (int i = mid+1; i <= end ; i++) {
                    if(segments[i].getMarker().equals("r")){
                        count++;
                    }
                }
                return count;
            }else if(segments[mid].getValue() < key){
                low = mid+ 1;
            }else {
                high = mid-1;
            }
        }

        return count;
    }
    private static int[] fastCountSegments(Segment[] segments, int[] points) {
        int[] cnt = new int[points.length];
       // int n = segments.length/2 - points.length;
        //write your code here
        Arrays.parallelSort(segments);

        int len = cnt.length;
        for (int i = 0; i < len; i++) {
            int l = binarySearchIterCountLeft(segments, 0, segments.length-1, points[i]);
            int r = binarySearchIterCountRight(segments, 0, segments.length-1, points[i]);
            cnt[i] = l + r - length;
        }
        return cnt;
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        length = n;
      //  int[] starts = new int[n];
      //  int[] ends = new int[n];
        int[] points = new int[m];
        Segment[] segments = new Segment[2*n+m];
        for (int i = 0; i < n; i++) {
//            starts[i] = scanner.nextInt();
//            ends[i] = scanner.nextInt();
            segments[i] = new Segment(scanner.nextInt(), "l");
            segments[n+i] = new Segment(scanner.nextInt(), "r");
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
            segments[2*n + i] = new Segment(points[i], "p");
        }
        //use fastCountSegments
        //int[] cnt = naiveCountSegments(starts, ends, points);
        int[] cnt = fastCountSegments(segments, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}

