package com.skbr.binarytree.traversal;

import com.skbr.binarytree.BinaryTree;
import com.skbr.binarytree.BinaryTree.Node;
import com.skbr.binarytree.BinaryTreeFactory;

public class LevelOrderTraversalRecursive {

	private static void levelOrderTraversal(BinaryTree binaryTree) {
		
		for(int level = 1; level <= binaryTree.getHeight() ; ++level) {
			printNodesAtLevel(binaryTree.getRoot(), level);
			System.out.println("");
		}
	}
	private static void printNodesAtLevel(Node root, int level) {
		if(root == null)
			return;
		if(level == 1)
			System.out.print(root);
		else if (level > 1) {
			printNodesAtLevel(root.getLeft(), level - 1);
			printNodesAtLevel(root.getRight(), level - 1);
		}
	}
	public static void main(String[] args) {

		BinaryTree binaryTree = BinaryTreeFactory.getPerfectBinaryTree();
		levelOrderTraversal(binaryTree);
	}
}
