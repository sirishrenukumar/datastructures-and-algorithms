package com.skbr.binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

	public static class Node {
		private int data;
		private Node left;
		private Node right;

		public Node(int data) {
			super();
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

		@Override
		public String toString() {
			return "[" + data + "]";
		}
	}

	private Node root;

	public BinarySearchTree(int data){
		insert(data);
	}
	
	public Node getRoot() {
		return root;
	}
	public void insert(int data) {
		root = insert(root, data);
	}

	private Node insert(Node root, int data) {
		if(root == null) 
			return new Node(data);
		
		if(data < root.data) {
			root.left = insert(root.left, data);
		} else if(data > root.data) {
			root.right = insert(root.right, data);
		}
		
		return root;
	}
	public void inorder() {
		inorder(root);
	}
	public void preorder() {
		preorder(root);
	}
	public void postorder() {
		postorder(root);
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
	

	private void inorder(Node root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root + ",");
		inorder(root.right);
	}

	private void preorder(Node root) {
		if (root == null)
			return;
		System.out.print(root + ",");
		preorder(root.left);
		preorder(root.right);
	}

	private void postorder(Node root) {
		if (root == null)
			return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root + ",");
	}

}
