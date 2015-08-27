package com.skbr.binarytree.traversal;

import java.util.LinkedList;
import java.util.Queue;

import com.skbr.binarytree.BinaryTree;
import com.skbr.binarytree.BinaryTree.Node;
import com.skbr.binarytree.BinaryTreeFactory;

public class LevelOrderTraversal {
	
	private static void levelOrderTraversal(Node root) {
		
		Queue<Node> queue = new LinkedList<Node>();
		
		if(root != null) {
			queue.add(root);
		}
		
		while(!queue.isEmpty()) {
			Node current = queue.remove();
			
			System.out.print(current + "->");
			
			/*
			 * Add the left child of the current node if present
			 */
			if (current.getLeft() != null) {
				queue.add(current.getLeft());
			}

			/*
			 * Add the right child of the current node if present
			 */
			if (current.getRight() != null) {
				queue.add(current.getRight());
			}
		}
	}

	public static void main(String[] args) {

		System.out.println("");
		System.out.println("7-node skewed");
		levelOrderTraversal(BinaryTreeFactory.getSevenNodeSkewedBinaryTree().getRoot());
		System.out.println("");
		System.out.println("7-node perfect");
		levelOrderTraversal(BinaryTreeFactory.getSevenNodesPerfectBinaryTree().getRoot());
		System.out.println("");
		System.out.println("15-node perfect");
		levelOrderTraversal(BinaryTreeFactory.getPerfectBinaryTree().getRoot());

	}

}
