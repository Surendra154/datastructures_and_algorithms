package com.reddy.graphs.week3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    static int[] dist;
    private static int distance(ArrayList<Integer>[] adj, int s, int t) {
        //write your code here
        dist[s] = 0;
        Queue<Integer> queue = new LinkedList<>();
        ((LinkedList<Integer>) queue).add(s);

        while (!queue.isEmpty()) {
            int u = ((LinkedList<Integer>) queue).pop();
            for (Integer neighbor:
                 adj[u]) {

                if(dist[neighbor] == -1) {
                    ((LinkedList<Integer>) queue).add(neighbor);
                    dist[neighbor] = dist[u] + 1;
                }

                if(neighbor == t) {
                    return dist [neighbor];
                }

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        dist = new int[n];
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            dist[i] = -1;
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, x, y));
    }
}

