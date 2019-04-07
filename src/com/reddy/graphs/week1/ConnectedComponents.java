package com.reddy.graphs.week1;

import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedComponents {
    static boolean[] visited;
    private static int numberOfComponents(ArrayList<Integer>[] adj) {
        int count = 0;
        //write your code here

        for (int v = 0; v < adj.length ; v++) {
            if (!visited[v]) {
                explore(adj, v);
                count++;
            }
        }

        return count;
    }

    private static void explore(ArrayList<Integer>[] adj, int v) {
        //write your code here
        visited[v] = true;

        for (Integer neighbor: adj[v]) {
            if(!visited[neighbor])  {
                explore(adj, neighbor);
            }
        }
        return;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        visited = new boolean[n];
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            visited[i] = false;
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        System.out.println(numberOfComponents(adj));
    }
}

