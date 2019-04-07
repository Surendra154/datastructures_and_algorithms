package com.reddy.graphs.week4;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Dijkstra {

    static int[] dist;

    static class NodeDist implements Comparable<NodeDist> {
        // target is nothing but index
        int target;
        int distance;

        public NodeDist(int target, int distance) {
            this.target = target;
            this.distance = distance;
        }

        @Override
        public int compareTo(NodeDist o) {
            if(this.distance > o.distance) {
                return 1;
            } else if(this.distance < o.distance) {
                return -1;
            } else {
                return 0;
            }
        }
    }
    private static int distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost,
            int s, int t) {

        dist[s] = 0;
        PriorityQueue<NodeDist> pQueue = new PriorityQueue<>();
        pQueue.add(new NodeDist(s, dist[s]));
        while (!pQueue.isEmpty()) {
            NodeDist u = pQueue.poll();

            for (Integer neighbor:
                 adj[u.target]) {
                int index = adj[u.target].indexOf(neighbor);
                if( dist[neighbor] > dist[u.target] + cost[u.target].get(index)) {
                    dist[neighbor] = dist[u.target] + cost[u.target].get(index);
                    pQueue.add(new NodeDist(neighbor, dist[neighbor]));
                }
            }
        }

        if(dist[t] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[t];
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];

        dist = new int[n];

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
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, cost, x, y));
    }
}

