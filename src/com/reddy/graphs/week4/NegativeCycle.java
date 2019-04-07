package com.reddy.graphs.week4;

import java.util.ArrayList;
import java.util.Scanner;

public class NegativeCycle {

    static long[] dist;

    private static int negativeCycle(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost) {
        // write your code here
        dist[0] = 0;
        int len = adj.length;

        for (int v = 0; v < len; v++) {
            for (int i = 0; i < adj.length; i++) {
                for (Integer neighbor:
                        adj[i]) {
                    int index = adj[i].indexOf(neighbor);
                    if( dist[neighbor] > dist[i] + cost[i].get(index)) {
                        dist[neighbor] = dist[i] + cost[i].get(index);
                        if(v == len - 1)
                            return 1;
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];

        dist = new long[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
            dist[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
        System.out.println(negativeCycle(adj, cost));
    }
}

