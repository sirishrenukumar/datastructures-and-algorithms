package com.skbr.binarysearchtree;

public class BinarySearchTreeMain {

	public static void main(String[] args) {

		BinarySearchTree binarySearchTree = BinarySearchTreeFactory.getFiveNodesBinarySearchTree();
		binarySearchTree.inorder();
	}

}
