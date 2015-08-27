package com.skbr.binarytree.traversal;

import java.util.LinkedList;
import java.util.Queue;

import com.skbr.binarytree.BinaryTree.Node;
import com.skbr.binarytree.BinaryTreeFactory;

public class ViewFromRight {

		private static void rightView(Node root) {
		
		Queue<Node> queue = new LinkedList<Node>();
		
		if(root != null) {
			queue.add(root);
		}
		
		while(!queue.isEmpty()) {
			
			/*
			 * All the nodes in the queue at the start of the loop are at the same level
			 */
			int nodeCount = queue.size();
			while(nodeCount > 0) {
				Node current = queue.remove();
		
				/*
				 * Last node at the level should be printed
				 */
				if(nodeCount == 1) {
					System.out.print(current + "->");
				}
					
				
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
				
				--nodeCount;
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {


		System.out.println("");
		System.out.println("7-node skewed");
		rightView(BinaryTreeFactory.getSevenNodeSkewedBinaryTree().getRoot());
		System.out.println("");
		System.out.println("7-node perfect");
		rightView(BinaryTreeFactory.getSevenNodesPerfectBinaryTree().getRoot());
		System.out.println("");
		System.out.println("15-node perfect");
		rightView(BinaryTreeFactory.getPerfectBinaryTree().getRoot());

		}
}
