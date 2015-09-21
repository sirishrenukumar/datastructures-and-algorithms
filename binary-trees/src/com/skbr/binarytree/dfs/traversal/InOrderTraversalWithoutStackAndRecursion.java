package com.skbr.binarytree.dfs.traversal;

import com.skbr.binarytree.BinaryTree;
import com.skbr.binarytree.BinaryTree.Node;
import com.skbr.binarytree.BinaryTreeFactory;

public class InOrderTraversalWithoutStackAndRecursion {

	public static void inorder(Node root) {

		if (root == null)
			return;

		Node current = root;
		while (current != null) {

			if(current.getLeft() == null) {
				
				/*
				 * The current node has no left subtree. Print the current node and then 
				 * descend to the right subtree
				 */
				System.out.print(current + ",");
				current = current.getRight();
				
			} else {

				/*
				 * If the current node has a left subtree, then the current node can
				 * become the inorder successor of some node in the left subtree
				 * 
				 * The current node is the inorder successor of the deepest and
				 * rightmost node in the left subtree
				 */
				
				/*
				 * Find the inorder predecessor that occurs somewhere in the left subtree
				 */
				Node predeccessor = current.getLeft();
				while (predeccessor.getRight() != null && predeccessor.getRight() != current) {
					predeccessor = predeccessor.getRight();
				}
				
				if(predeccessor.getRight() == current) {
					System.out.print(current + ",");
					predeccessor.setRight(null);
					current = current.getRight();
					
				} else {
					predeccessor.setRight(current);
					current = current.getLeft();
				}
			}
		}
	}

	public static void main(String[] args) {

		BinaryTree binaryTree = BinaryTreeFactory.getSevenNodesPerfectBinaryTree();

		System.out.println();
		System.out.println("Inorder recursive");
		binaryTree.inorder();
		System.out.println();
		System.out.println("Inorder Morris traversal");
		inorder(binaryTree.getRoot());

		binaryTree = BinaryTreeFactory.getPerfectBinaryTree();
		System.out.println();
		System.out.println("Inorder recursive");
		binaryTree.inorder();
		System.out.println();
		System.out.println("Inorder Morris traversal");
		inorder(binaryTree.getRoot());

	}

}
