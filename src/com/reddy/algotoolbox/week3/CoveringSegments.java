package com.reddy.algotoolbox.week3;

import java.util.*;

public class CoveringSegments {

    private static ArrayList<Integer> optimalPoints(Segment[] segments) {
        //write your code here
        ArrayList<Integer> points = new ArrayList<Integer>();

        Arrays.sort(segments);

        int point = Math.max(segments[0].start, segments[0].end);
        points.add(point);

        for (int i = 1; i < segments.length; i++) {

            if(point >= segments[i].start && point <= segments[i].end)
                continue;
            else{
                point = Math.max(segments[i].start, segments[i].end);
                points.add(point);

            }

        }
        return points;
    }

    private static class Segment implements Comparable<Segment>{
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Start : " + start + " End : " + end ;
        }

        @Override
        public int compareTo(Segment o) {
            if(end < o.end)
                return -1;
            else if(end > o.end)
                return 1;
            else
                return 0;
        }
    }

    private static class SegementComparator implements Comparator<Segment> {

        @Override
        public int compare(Segment o1, Segment o2) {
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        ArrayList<Integer> points = optimalPoints(segments);
        System.out.println(points.size());
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
