package com.reddy.datastructures.week6;

import java.util.*;
import java.io.*;

public class is_bst_hard {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public class IsBSTH {
        class Node {
            int key;
            int left;
            int right;

            Node(int key, int left, int right) {
                this.left = left;
                this.right = right;
                this.key = key;
            }
        }

        int nodes;
        Node[] tree;
        int aux = Integer.MIN_VALUE;
        boolean isBst = true;

        void read() throws IOException {
            FastScanner in = new FastScanner();
            nodes = in.nextInt();
            tree = new Node[nodes];
            for (int i = 0; i < nodes; i++) {
                tree[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());
            }
        }

        boolean isBinarySearchTree(Node[] tree, int index) {
            // Implement correct algorithm here
            /**
             * idea do a inorder traversal , it should be in increasing order
             */
            if(tree.length == 0 || tree.length == 1)
                return true;


            //inTraverse(tree, index);
            // return isBst;
            return isBst(tree, index, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        boolean isBst(Node[] tree, int child, long min, long max) {
            if( child == -1)
                return true;

            if(tree[child].key < min || tree[child].key >= max)
                return false;

            return isBst(tree, tree[child].left, min, tree[child].key)
                    && isBst(tree, tree[child].right, tree[child].key, max);
        }
        void inTraverse(Node[] tree, int child){
            if( child == -1)
                return;
            inTraverse(tree, tree[child].left);
            if(tree[child].key < aux ){
                isBst = false;
                return;
            }else {
                aux = tree[child].key;
            }
            inTraverse(tree, tree[child].right);
            return;
        }
        boolean solve() {
            return isBinarySearchTree(tree, 0);
        }
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new is_bst_hard().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }
    public void run() throws IOException {
        IsBSTH tree = new IsBSTH();
        tree.read();
        if (tree.solve()) {
            System.out.println("CORRECT");
        } else {
            System.out.println("INCORRECT");
        }
    }
}
