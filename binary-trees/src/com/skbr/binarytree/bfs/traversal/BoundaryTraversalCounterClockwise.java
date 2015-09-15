package com.skbr.binarytree.bfs.traversal;

import java.util.LinkedList;
import java.util.Queue;

public class BoundaryTraversalCounterClockwise {
	
	private static class BinarySearchTree {

		private static class Node {
			private int data;
			private Node left;
			private Node right;
			public Node(int data) {
				this.data = data;
			}
			public int getData() {
				return data;
			}
			public Node getLeft() {
				return left;
			}
			public Node getRight() {
				return right;
			}
			public void setLeft(Node left) {
				this.left = left;
			}
			public void setRight(Node right) {
				this.right = right;
			}
			
			public boolean isLeaf() {
				return (left == null && right == null);
			}
			@Override
			public String toString() {
				return "[" + data + "]";
			}
			
		}
		
		private Node root;

		public void inorder() {
			inorder(root);
		}
		private void inorder(Node root) {
			if(root == null)
				return;
			
			inorder(root.getLeft());
			System.out.print(root);
			inorder(root.getRight());
		}
		public void levelOrder() {
			
			Queue<Node> queue = new LinkedList<Node>();
			
			if(root!=null)
				queue.add(root);
			
			while(!queue.isEmpty()) {
				
				int nodeCount = queue.size();
				
				while(nodeCount > 0) {
					Node current = queue.remove();
					System.out.print(current + ",");
					
					if(current.left!= null)
						queue.add(current.left);
					
					if(current.right!= null)
						queue.add(current.right);

					--nodeCount;
				}
				System.out.println("");
			}
		}

		public void insert(int data) {
			root = insert(root, data);
		}
		private Node insert(Node root, int data) {
			if(root == null)
				return new Node(data);
			else if(data < root.getData())
				root.setLeft(insert(root.left,data));
			else if(root.getData() < data)
				root.setRight(insert(root.getRight(), data));
			return root;
		}
		
		public void boundaryOrder() {
			partialPreorder(root);
			partialInorder(root);
			partialPostOrder(root);
		}
		private void partialPreorder(Node root) {
			if(root == null)
				return;
			
			/*
			 * Traverse only the left subtrees and print only the internal nodes 
			 */
			if(!root.isLeaf())
				System.out.print(root + " ");
			partialPreorder(root.getLeft());
		}
		private void partialInorder(Node root) {
			if(root == null)
				return;

			partialInorder(root.getLeft());
			/*
			 * Print only the leaves. 
			 */
			if(root.isLeaf())
				System.out.print(root + " ");
			partialInorder(root.getRight());
			
		}
		private void partialPostOrder(Node root) {
			if(root == null)
				return;
			/*
			 * Traverse only the right subtrees and print only the internal nodes 
			 */
			partialPostOrder(root.getRight());
			if(!root.isLeaf())
				System.out.print(root + " ");
		}
		
	}

	public static void main(String[] args) {
		
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		
		/*
		 *                     4
		 *                2         6 
		 *               1 3       5  7
		 */
		
		binarySearchTree.insert(4);
		binarySearchTree.insert(2);
		binarySearchTree.insert(1);
		binarySearchTree.insert(3);
		binarySearchTree.insert(6);
		binarySearchTree.insert(5);
		binarySearchTree.insert(7);
		
		System.out.println("\nInorder");
		binarySearchTree.inorder();
		
		System.out.println("\nLevel order");
		binarySearchTree.levelOrder();
		
		System.out.println("\nBoundary order");
		
		binarySearchTree.boundaryOrder();

		

	}

}
