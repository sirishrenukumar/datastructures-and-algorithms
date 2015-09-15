package com.skbr.binarysearchtree;

import com.skbr.binarytree.BinaryTree;
import com.skbr.binarytree.BinaryTree.Node;

public class IsBinarySearchTree {
	
	private static boolean isBinarySearchTree(BinaryTree binaryTree) {
		return isBinarySearchTree(binaryTree.getRoot(), Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isBinarySearchTree(Node root, int minValue, int maxValue) {
		if(root == null)
			return true;
		return isBinarySearchTree(root.getLeft(), minValue, root.getData()) &&
			   isBinarySearchTree(root.getRight(), root.getData(), maxValue) &&
			   minValue < root.getData() && root.getData() < maxValue;
	}

	public static void main(String[] args) {
		
		BinaryTree binaryTree = new BinaryTree(5);
		binaryTree.insertLeft(binaryTree.getRoot(), 1);
		binaryTree.insertRight(binaryTree.getRoot(), 10);
		
		binaryTree.insertLeft(binaryTree.getRoot().getLeft(), 0);
		binaryTree.insertRight(binaryTree.getRoot().getLeft(), 6);

		binaryTree.inorder();
		
		System.out.println("Is BST : "+ isBinarySearchTree(binaryTree));
	}

}
