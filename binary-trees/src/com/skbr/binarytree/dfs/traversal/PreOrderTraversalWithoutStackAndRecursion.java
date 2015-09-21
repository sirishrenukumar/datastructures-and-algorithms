package com.skbr.binarytree.dfs.traversal;

import com.skbr.binarytree.BinaryTree;
import com.skbr.binarytree.BinaryTree.Node;
import com.skbr.binarytree.BinaryTreeFactory;

public class PreOrderTraversalWithoutStackAndRecursion {

	public static void preorder(Node root) {

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
					predeccessor.setRight(null);
					current = current.getRight();
					
				} else {
					
					/*
					 * Single line change v/s inorder traversal
					 */
					System.out.print(current + ",");
					predeccessor.setRight(current);
					current = current.getLeft();
				}
			}
		}
	}

	public static void main(String[] args) {

		BinaryTree binaryTree = BinaryTreeFactory.getSevenNodesPerfectBinaryTree();

		System.out.println();
		System.out.println("Preorder recursive");
		binaryTree.preorder();
		System.out.println();
		System.out.println("Preorder Morris traversal");
		preorder(binaryTree.getRoot());

		binaryTree = BinaryTreeFactory.getPerfectBinaryTree();
		System.out.println();
		System.out.println("Preorder recursive");
		binaryTree.preorder();
		System.out.println();
		System.out.println("Preorder Morris traversal");
		preorder(binaryTree.getRoot());

	}

}
