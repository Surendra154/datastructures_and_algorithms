package com.reddy.graphs.week3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bipartite {
    static String[] marker;
    static int[] dist;
    static String markerTemp="R";
    static boolean isBipartite = true;
    private static int bipartite(ArrayList<Integer>[] adj) {
        //write your code here
        /**
         * Mark vertices red R and blue B no two end points should have same color
         */

       // dist[0] = 0;
        for (int i = 0; i < adj.length; i++) {
            marker[i] = markerTemp;

            if(dist[i] == -1) {
                dist[i] = 0;
                Queue<Integer> queue = new LinkedList<>();
                ((LinkedList<Integer>) queue).add(i);

                while (!queue.isEmpty()) {
                    int u = ((LinkedList<Integer>) queue).pop();

                    for (Integer neighbor:
                            adj[u]) {
                        if(dist[neighbor] == -1) {
                            markerTemp = (marker[u] == "B" ? "R" : "B");
                            marker[neighbor] = markerTemp;
                        }

                    }
                    for (Integer neighbor:
                            adj[u]) {
                        if(dist[neighbor] == -1) {
                           // marker[neighbor] = markerTemp;
                            ((LinkedList<Integer>) queue).add(neighbor);
                            dist[neighbor] = dist[u] + 1;
                        }

                        if(marker[neighbor].equals(marker[u])) {
                            isBipartite = false;
                            // return 0;
                        }

                    }
                }
            }

        }
        if(isBipartite)
            return 1;
        else
            return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        marker = new String[n];
        dist = new int[n];
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            marker[i] = null;
            dist[i] = -1;
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        System.out.println(bipartite(adj));
    }
}

