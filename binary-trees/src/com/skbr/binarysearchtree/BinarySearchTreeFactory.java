package com.skbr.binarysearchtree;

public class BinarySearchTreeFactory {

	public static BinarySearchTree getThreeNodesBinarySearchTree() {
		BinarySearchTree binarySearchTree = new BinarySearchTree(2);
		
		binarySearchTree.insert(1);
		binarySearchTree.insert(3);
		
		return binarySearchTree;
	}
	public static BinarySearchTree getFiveNodesBinarySearchTree() {
		BinarySearchTree binarySearchTree = new BinarySearchTree(3);
		
		binarySearchTree.insert(1);
		binarySearchTree.insert(2);
		binarySearchTree.insert(4);
		binarySearchTree.insert(5);
		
		return binarySearchTree;
	}
}
