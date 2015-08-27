package com.skbr.binarytree.traversal;

import java.util.LinkedList;
import java.util.Queue;

import com.skbr.binarytree.BinaryTree.Node;
import com.skbr.binarytree.BinaryTreeFactory;

public class ViewFromLeft {

		private static void leftView(Node root) {
		
		Queue<Node> queue = new LinkedList<Node>();
		
		if(root != null) {
			queue.add(root);
		}
		
		while(!queue.isEmpty()) {
			
			/*
			 * All the nodes in the queue at the start of the loop are at the same level
			 */
			int nodeCount = queue.size();
			boolean firstNodeInLevel = true;
			while(nodeCount > 0) {
				Node current = queue.remove();
				
				if(firstNodeInLevel) {
					System.out.print(current + "->");
					firstNodeInLevel = !firstNodeInLevel;
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
		leftView(BinaryTreeFactory.getSevenNodeSkewedBinaryTree().getRoot());
		System.out.println("");
		System.out.println("7-node perfect");
		leftView(BinaryTreeFactory.getSevenNodesPerfectBinaryTree().getRoot());
		System.out.println("");
		System.out.println("15-node perfect");
		leftView(BinaryTreeFactory.getPerfectBinaryTree().getRoot());

		}
}
