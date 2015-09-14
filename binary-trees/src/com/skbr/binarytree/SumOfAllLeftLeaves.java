package com.skbr.binarytree;

import com.skbr.binarytree.BinaryTree.Node;

public class SumOfAllLeftLeaves {

	private static int sumOfAllLeftLeaves(Node root, boolean isLeftChild) {
		if (root == null)
			return 0;

		if (root.isLeaf() && isLeftChild) {
			System.out.println("Adding " + root + " to sum");
			return root.getData();
		}
			

		return sumOfAllLeftLeaves(root.getLeft(), true) + sumOfAllLeftLeaves(root.getRight(), false);
	}

	public static void main(String[] args) {

		/*
		 * http://www.geeksforgeeks.org/find-sum-left-leaves-given-binary-tree/
		 */
		BinaryTree binaryTree = new BinaryTree(20);
		binaryTree.insertLeft(binaryTree.getRoot(), 9);
		binaryTree.insertRight(binaryTree.getRoot(), 49);

		binaryTree.insertLeft(binaryTree.getRoot().getLeft(), 5);
		binaryTree.insertRight(binaryTree.getRoot().getLeft(), 12);

		binaryTree.insertRight(binaryTree.getRoot().getLeft().getRight(), 15);

		binaryTree.insertLeft(binaryTree.getRoot().getRight(), 23);
		binaryTree.insertRight(binaryTree.getRoot().getRight(), 52);

		binaryTree.insertLeft(binaryTree.getRoot().getRight().getRight(), 50);

		System.out.println("Sum of all left leaves is " + sumOfAllLeftLeaves(binaryTree.getRoot(), false));
	}

}
