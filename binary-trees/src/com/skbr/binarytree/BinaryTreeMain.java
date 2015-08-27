package com.skbr.binarytree;

public class BinaryTreeMain {

	public static void main(String[] args) {
		
		BinaryTree binaryTree = BinaryTreeFactory.getPerfectBinaryTree();
		binaryTree.inorder();
		binaryTree.printAllRootToLeafPaths();

		BinaryTree threeNodesTree = BinaryTreeFactory.getThreeNodesPerfectBinaryTree();
		threeNodesTree.doubleTree();
		threeNodesTree.inorder();
		
		System.out.println("\nIs sum tree : " + threeNodesTree.sumTree());
		
	}

}
