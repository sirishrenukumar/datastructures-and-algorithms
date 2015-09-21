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
	public static BinaryTree getSevenNodeSkewedBinaryTree() {
		BinaryTree binaryTree = new BinaryTree(1);
		Node root = binaryTree.getRoot();
		Node two = binaryTree.insertLeft(root, 2);
		Node three = binaryTree.insertLeft(two, 3);
		Node four = binaryTree.insertLeft(three, 4);
		Node five = binaryTree.insertLeft(four, 5);
		Node six = binaryTree.insertLeft(five, 6);
		binaryTree.insertLeft(six, 7);
		return binaryTree;
	}
	public static BinaryTree getThirtyOneNodesPerfectBinaryTree() {

		BinaryTree binaryTree = new BinaryTree(1);
		Node root = binaryTree.getRoot();

		Node two = binaryTree.insertLeft(root, 2);
		Node three = binaryTree.insertRight(root, 3);

		Node four = binaryTree.insertLeft(two, 4);
		Node five = binaryTree.insertRight(two, 5);

		Node six = binaryTree.insertLeft(three, 6);
		Node seven = binaryTree.insertRight(three, 7);

		Node eight = binaryTree.insertLeft(four, 8);
		Node nine = binaryTree.insertRight(four, 9);

		Node ten = binaryTree.insertLeft(five, 10);
		Node eleven = binaryTree.insertRight(five, 11);

		Node twelve = binaryTree.insertLeft(six, 12);
		Node thirteen = binaryTree.insertRight(six, 13);

		Node fourteen = binaryTree.insertLeft(seven, 14);
		Node fifteen = binaryTree.insertRight(seven, 15);

		binaryTree.insertLeft(eight, 16);
		binaryTree.insertRight(eight, 17);

		binaryTree.insertLeft(nine, 18);
		binaryTree.insertRight(nine, 19);

		binaryTree.insertLeft(ten, 20);
		binaryTree.insertRight(ten, 21);
		
		binaryTree.insertLeft(eleven, 22);
		binaryTree.insertRight(eleven, 23);

		binaryTree.insertLeft(twelve, 24);
		binaryTree.insertRight(twelve, 25);

		binaryTree.insertLeft(thirteen, 26);
		binaryTree.insertRight(thirteen, 27);

		binaryTree.insertLeft(fourteen, 28);
		binaryTree.insertRight(fourteen, 29);

		binaryTree.insertLeft(fifteen, 30);
		binaryTree.insertRight(fifteen, 31);

		return binaryTree;
	}

}
