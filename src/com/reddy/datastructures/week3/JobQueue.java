package com.reddy.datastructures.week3;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class JobQueue {
    private int numWorkers;
    private int[] jobs;

    private int[] assignedWorker;
    private long[] startTime;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    private void readData() throws IOException {
        numWorkers = in.nextInt();
        int m = in.nextInt();
        jobs = new int[m];
        for (int i = 0; i < m; ++i) {
            jobs[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        for (int i = 0; i < jobs.length; ++i) {
            out.println(assignedWorker[i] + " " + startTime[i]);
        }
    }

    /*private void assignJobs() {
        // TODO: replace this code with a faster algorithm.
        assignedWorker = new int[jobs.length];
        startTime = new long[jobs.length];
        long[] nextFreeTime = new long[numWorkers];
        for (int i = 0; i < jobs.length; i++) {
            int duration = jobs[i];
            int bestWorker = 0;
            for (int j = 0; j < numWorkers; ++j) {
                if (nextFreeTime[j] < nextFreeTime[bestWorker])
                    bestWorker = j;
            }
            assignedWorker[i] = bestWorker;
            startTime[i] = nextFreeTime[bestWorker];
            nextFreeTime[bestWorker] += duration;
        }
    }*/

    private void assignJobs() {
        // TODO: replace this code with a faster algorithm.
        assignedWorker = new int[jobs.length];
        startTime = new long[jobs.length];

        PriorityQueue<Worker> workerQueue = new PriorityQueue<>(numWorkers, new SchedularComparator() );

        for (int j = 0; j < numWorkers ; j++) {
            workerQueue.add(new Worker(0, j));
        }

        long[] nextFreeTime = new long[numWorkers];
        /**
         * for each job
         * 1. take the best worker
         * 2. store index and starttime
         * 3. compute its next process time
         * 4.push it to priority queue
         */
        for (int i = 0; i < jobs.length; i++) {
            int duration = jobs[i];
            Worker bestWorker = workerQueue.poll();
            assignedWorker[i] = bestWorker.getIndex();
            startTime[i] = nextFreeTime[bestWorker.getIndex()];
            nextFreeTime[bestWorker.getIndex()] += duration;
            workerQueue.offer(new Worker(nextFreeTime[bestWorker.getIndex()], bestWorker.getIndex()));
        }
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        assignJobs();
        writeResponse();
        out.close();
    }

    static  class Worker {
        private long finishTime; // == startTime + processTime
        private int index;

        public Worker(long finishTime, int index) {
            this.finishTime = finishTime;
            this.index = index;
        }

        public long getFinishTime() {
            return finishTime;
        }

        public void setFinishTime(long finishTime) {
            this.finishTime = finishTime;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    class SchedularComparator implements Comparator<Worker> {

        @Override
        public int compare(Worker w1, Worker w2) {
            if(w1.getFinishTime() > w2.getFinishTime()){
                return 1;
            }else if(w1.getFinishTime() < w2.getFinishTime()){
                return -1;
            }else{//both equal then take one with least index
                if(w1.getIndex() > w2.getIndex()){
                    return 1;
                }else if(w1.getIndex() < w2.getIndex()){
                    return -1;
                }
            }
            return 0;
        }
    }
    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
