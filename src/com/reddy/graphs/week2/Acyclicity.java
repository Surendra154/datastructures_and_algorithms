package com.reddy.graphs.week2;

import java.util.ArrayList;
import java.util.Scanner;

public class Acyclicity {

    static boolean[] visited;
    static boolean[] recStack;

    private static int acyclic(ArrayList<Integer>[] adj) {
        //write your code here
        for (int i = 0; i < adj.length ; i++) {
            if (explore(adj, i) == 1) {
                return 1;
            }
        }
        return 0;
    }

    private static int explore(ArrayList<Integer>[] adj, int v) {
        //write your code here

        visited[v] = true;
        recStack[v] = true;
        for (Integer neighbor: adj[v]) {

            if(recStack[neighbor]){
                return 1;
            }
            if (!visited[neighbor])  {
                if(explore(adj, neighbor) == 1) {
                    return 1;
                }

            }
        }
        recStack[v] = false;
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        visited = new boolean[n];
        recStack = new boolean[n];

        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            visited[i] = false;
            recStack[i] = false;
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        System.out.println(acyclic(adj));
    }
}