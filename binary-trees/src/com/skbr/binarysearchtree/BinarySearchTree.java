package com.skbr.binarysearchtree;

public class BinarySearchTree {

	static class Node {
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
			return "Node [" + data + "]";
		}
	}

	private Node root;

	public BinarySearchTree(int data){
		insert(data);
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
	

	private void inorder(Node root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root + ", ");
		inorder(root.right);
	}

	private void preorder(Node root) {
		if (root == null)
			return;
		System.out.println(root);
		preorder(root.left);
		preorder(root.right);
	}

}
