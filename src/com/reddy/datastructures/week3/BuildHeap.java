package com.reddy.datastructures.week3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BuildHeap {
    private int[] data;
    private List<Swap> swaps = new ArrayList<Swap>();;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new BuildHeap().solve();
    }

    private void readData() throws IOException {
        int n = in.nextInt();
        data = new int[n];
        for (int i = 0; i < n; ++i) {
          data[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        out.println(swaps.size());
        for (Swap swap : swaps) {
          out.println(swap.index1 + " " + swap.index2);
        }
    }

    /*private void generateSwaps() {
      swaps = new ArrayList<Swap>();
      // The following naive implementation just sorts 
      // the given sequence using selection sort algorithm
      // and saves the resulting sequence of swaps.
      // This turns the given array into a heap, 
      // but in the worst case gives a quadratic number of swaps.
      //
      // TODO: replace by a more efficient implementation
      for (int i = 0; i < data.length; ++i) {
        for (int j = i + 1; j < data.length; ++j) {
          if (data[i] > data[j]) {
            swaps.add(new Swap(i, j));
            int tmp = data[i];
            data[i] = data[j];
            data[j] = tmp;
          }
        }
      }
    }*/

    public void generateSwaps(){
        swaps = new ArrayList<Swap>();

        for (int i = Math.round(data.length/2); i >= 0 ; i--) {
            siftDown(i);
        }
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        generateSwaps();
        writeResponse();
        out.close();
    }

    //utility methods
    public void siftDown(int i){
        int minIndex = i;
        int l = leftChild(i);

        if(l < data.length && data[l] < data[minIndex]){
            minIndex = l;
        }

        int r = rightChild(i);

        if(r < data.length && data[r] < data[minIndex]){
            minIndex = r;
        }

        if(i != minIndex){
            swap(minIndex, i);
            siftDown(minIndex);
        }else {
            return;
        }
    }

    public void swap(int minIndex, int i){
        swaps.add(new Swap(i, minIndex));
        int temp = data[minIndex];
        data[minIndex] = data[i];
        data[i] = temp;
    }

    public int leftChild(int i){
        return 2*i+1;
    }

    public int rightChild(int i){
        return 2*i+2;
    }
    static class Swap {
        int index1;
        int index2;

        public Swap(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
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
