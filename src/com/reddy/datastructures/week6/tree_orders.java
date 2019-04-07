package com.reddy.datastructures.week6;

import java.util.*;
import java.io.*;

public class tree_orders {
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

	public class TreeOrders {
		int n;
		int[] key, left, right;
        Helper[] helper;

		class Helper {
		    int left;
		    int right;
		    int key;
        }
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			key = new int[n];
			left = new int[n];
			right = new int[n];
            helper = new Helper[n];
			for (int i = 0; i < n; i++) {
			    helper[i] = new Helper();
				key[i] = in.nextInt();
				helper[i].key = key[i];
				left[i] = in.nextInt();
                helper[i].left = left[i];
				right[i] = in.nextInt();
                helper[i].right = right[i];
			}
		}

		List<Integer> inOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
                        // Finish the implementation
                        // You may need to add a new recursive method to do that
            inTraverse(result, helper, 0);
			return result;
		}

		void inTraverse(ArrayList<Integer> arr, Helper[] helper, int child){
		    if( child == -1)
		        return;
		    inTraverse(arr, helper, helper[child].left);
		    arr.add(helper[child].key);
		    inTraverse(arr, helper, helper[child].right);
        }

		List<Integer> preOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
                        // Finish the implementation
                        // You may need to add a new recursive method to do that
            preTraverse(result,  helper,0);
			return result;
		}

        void preTraverse(ArrayList<Integer> arr, Helper[] helper, int child){
            if( child == -1)
                return;
            arr.add(helper[child].key);
            preTraverse(arr, helper, helper[child].left);
            preTraverse(arr, helper, helper[child].right);
        }

		List<Integer> postOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
                        // Finish the implementation
                        // You may need to add a new recursive method to do that
            postTraverse(result, helper, 0);
			return result;
		}

        void postTraverse(ArrayList<Integer> arr, Helper[] helper, int child){
            if( child == -1)
                return;
            postTraverse(arr, helper, helper[child].left);
            postTraverse(arr, helper, helper[child].right);
            arr.add(helper[child].key);
        }
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_orders().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}

	public void print(List<Integer> x) {
		for (Integer a : x) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public void run() throws IOException {
		TreeOrders tree = new TreeOrders();
		tree.read();
		print(tree.inOrder());
		print(tree.preOrder());
		print(tree.postOrder());
	}
}
