package com.skbr.binarysearchtree;

import com.skbr.binarysearchtree.BinarySearchTree.Node;

public class CeilFloor {

	private static int ceil(Node root, int key) {

		if (root == null)
			return -1;

		if (root.getData() == key)
			return key;

		if (root.getData() < key)
			return ceil(root.getRight(), key);

		int ceil = ceil(root.getLeft(), key);

		return ceil >= key ? ceil : root.getData();
	}
	
	private static int floor(Node root, int key) {

		if (root == null)
			return -1;

		if (root.getData() == key)
			return key;

		if(key < root.getData())
			return floor(root.getLeft(), key);
		
		int floor = floor(root.getRight(), key);
		
		return floor <= key ? floor : root.getData();
	}

	public static void main(String[] args) {

		int nodes[] = new int[] { 4, 1, 2, 3, 6, 7, 8 };
		BinarySearchTree binarySearchTree = BinarySearchTreeFactory.getBinarySearchTree(nodes);
		binarySearchTree.levelOrder();

		for (int i = 0; i < nodes.length; ++i) {
			System.out.println("Ceil of " + (nodes[i] - 1) + " is " + ceil(binarySearchTree.getRoot(), nodes[i] - 1));
		}

		for (int i = 0; i < nodes.length; ++i) {
			System.out.println("Floor of " + (nodes[i] - 1) + " is " + floor(binarySearchTree.getRoot(), nodes[i] - 1));
		}
		
	}

}
