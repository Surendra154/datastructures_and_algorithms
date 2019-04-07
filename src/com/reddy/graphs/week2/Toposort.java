package com.reddy.graphs.week2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Toposort {
    static boolean[] visited;
    static boolean[] added;

    private static ArrayList<Integer> toposort(ArrayList<Integer>[] adj) {
        int used[] = new int[adj.length];
        ArrayList<Integer> order = new ArrayList<Integer>();
        //write your code here
        for (int i = 0; i < adj.length; i++) {
            dfs(adj, order, i);
        }
        Collections.reverse(order);
        return order;
    }

    private static void dfs(ArrayList<Integer>[] adj,  ArrayList<Integer> order, int s) {
      //write your code here
        visited[s] = true;
        for (Integer neighbor:
             adj[s]) {
            if (!visited[neighbor]) {
                dfs(adj, order, neighbor);
            }

        }
        if(!added[s]) {
            added[s] = true;
            order.add(s);
        }
        return;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        visited = new boolean[n];
        added = new boolean[n];
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            visited[i] = false;
            added[i] = false;
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        ArrayList<Integer> order = toposort(adj);
        for (int x : order) {
            System.out.print((x + 1) + " ");
        }
    }
}

