package com.skbr.binarytree;

public class BinaryTree {

	public static class Node {
		private int data;
		private Node left;
		private Node right;

		public Node(int data) {
			super();
			this.data = data;
		}

		@Override
		public String toString() {
			return "[" + data + "]";
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
		
		public void setData(int data) {
			this.data = data;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public boolean isLeaf() {
			return left == null && right == null;
		}
		
		
	}

	private Node root;

	public BinaryTree(int data) {
		root = new Node(data);
	}

	public Node getRoot() {
		return root;
	}

	public Node insertLeft(Node root, int data) {
		Node node = new Node(data);
		root.left = node;
		return node;
	}

	public Node insertRight(Node root, int data) {
		Node node = new Node(data);
		root.right = node;
		return node;
	}

	public void doubleTree() {
		doubleTree(root);
	}

	private void doubleTree(Node root) {
		
		/*
		 * 	- For every node, create a new left child node with the same value
		 * 	- Use postOrder to achieve this
		 */
		if(root == null) 
			return;
		
		/*
		 * 	- Complete for the subtrees first
		 */
		doubleTree(root.left);
		doubleTree(root.right);

		/*
		 * 	- Store the existing left child node
		 * 	- Insert new left child node
		 * 	- Link back old left child node under the new left child node
		 */
		Node oldLeft = root.left;
		Node newLeft = insertLeft(root, root.data);
		newLeft.left = oldLeft;
	}
	
	public boolean sumTree() {
		return root.data == sumTree(root);
	}
	
	private int sumTree(Node root) {
		if(root == null)
			return 0;
		else if (root.left == null && root.right == null) 
			return root.data;
		else
			return sumTree(root.left) + sumTree(root.right);
	}
	
	public int getHeight() {
		return getHeight(root);
	}
	private int getHeight(Node root) {
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 1;
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}

	public void printAllRootToLeafPaths() {
		System.out.println("\nAll root to leaf paths");
		printAllRootToLeafPaths(root, "");
	}
	
	private void printAllRootToLeafPaths(Node subTreeRoot, String prefix) {
		if(subTreeRoot == null) 
			return;
		if(subTreeRoot.left == null && subTreeRoot.right == null)
			System.out.println(prefix + subTreeRoot.data);
		
		prefix = prefix + subTreeRoot.data + "->";
		printAllRootToLeafPaths(subTreeRoot.left, prefix);
		printAllRootToLeafPaths(subTreeRoot.right, prefix);
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
