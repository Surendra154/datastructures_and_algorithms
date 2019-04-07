package com.reddy.datastructures.week1;

import java.util.*;
import java.io.*;

public class tree_height {
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

	public class Node {
        ArrayList<Node> childs= new ArrayList<>();
        int label;
        int height;

        public Node(int label){
            this.label = label;
        }

        public void addChild(Node child){
            this.childs.add(child);
        }

        public void setLabel(int label){
            this.label = label;
        }

        public void setHeight(int height){
            this.height = height;
        }
    }
	public class TreeHeight {
		int n;
		int parent[];
        int root;
        Node[] nodes;

		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			nodes = new Node[n];

            for (int i = 0; i < n; i++) {
                nodes[i] = new Node(i);
            }
		//	parent = new int[n];
			for (int child_index = 0; child_index < n; child_index++) {
				//parent[i] = in.nextInt();
                int parent_index = in.nextInt();

                if(parent_index == -1){
                    root = child_index;
                }else{
                    nodes[parent_index].addChild(nodes[child_index]);
                }
			}
		}

		int computeHeight() {
                        // Replace this code with a faster implementation

            Queue<Node> queue = new LinkedList<>();
            int height = 1;

            Node rootNode = nodes[root];
            HashMap<Integer, Boolean> heightMap = new HashMap<>(); // level and value is if it is accounted for

            rootNode.setHeight(1);
            heightMap.put(1, false);

            if(rootNode.childs.size() > 0){
               if(!heightMap.get(1)){
                   heightMap.put(1, true);
                   height++;
                   heightMap.put(height, false);
               }
                for(Node n: rootNode.childs){
                    n.setHeight(height);
                    ((LinkedList<Node>) queue).add(n);
                }
            }

            while (!queue.isEmpty()){
                Node node = ((LinkedList<Node>) queue).pop();


                if(node.childs.size() > 0){

                    if(!heightMap.get(node.height)){
                        /**
                         * check once for a sibling then accounts for it
                         * prepares for the children
                         * so for any other sibling there is not increase in height :)
                         * HashMap to rescue lol :P
                         */
                        heightMap.put(node.height, true);
                        height++;
                        heightMap.put(height, false);
                    }

                    for (Node n:
                        node.childs ) {
                        n.setHeight(height);
                        ((LinkedList<Node>) queue).add(n);
                    }
                }
            }

			return height;
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}
