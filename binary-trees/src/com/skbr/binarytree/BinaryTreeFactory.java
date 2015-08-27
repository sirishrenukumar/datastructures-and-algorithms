package com.skbr.binarytree;

import com.skbr.binarytree.BinaryTree.Node;

public class BinaryTreeFactory {

	public static BinaryTree getOneNodeBinaryTree() {
		return new BinaryTree(1);
	}

	public static BinaryTree getThreeNodesPerfectBinaryTree() {
		BinaryTree binaryTree = new BinaryTree(1);
		Node root = binaryTree.getRoot();

		binaryTree.insertLeft(root, 2);
		binaryTree.insertRight(root, 3);

		return binaryTree;
	}

	public static BinaryTree getSevenNodesPerfectBinaryTree() {
		BinaryTree binaryTree = new BinaryTree(1);
		Node root = binaryTree.getRoot();

		Node two = binaryTree.insertLeft(root, 2);
		Node three = binaryTree.insertRight(root, 3);

		binaryTree.insertLeft(two, 4);
		binaryTree.insertRight(two, 5);

		binaryTree.insertLeft(three, 6);
		binaryTree.insertRight(three, 7);

		return binaryTree;
	}

	public static BinaryTree getPerfectBinaryTree() {

		BinaryTree binaryTree = new BinaryTree(1);
		Node root = binaryTree.getRoot();

		Node two = binaryTree.insertLeft(root, 2);
		Node three = binaryTree.insertRight(root, 3);

		Node four = binaryTree.insertLeft(two, 4);
		Node five = binaryTree.insertRight(two, 5);

		Node six = binaryTree.insertLeft(three, 6);
		Node seven = binaryTree.insertRight(three, 7);

		binaryTree.insertLeft(four, 8);
		binaryTree.insertRight(four, 9);

		binaryTree.insertLeft(five, 10);
		binaryTree.insertRight(five, 11);

		binaryTree.insertLeft(six, 12);
		binaryTree.insertRight(six, 13);

		binaryTree.insertLeft(seven, 14);
		binaryTree.insertRight(seven, 15);

		return binaryTree;
	}

}
