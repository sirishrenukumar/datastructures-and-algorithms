package com.skbr.binarytree.bfs.traversal;

import java.util.LinkedList;
import java.util.Queue;

import com.skbr.binarytree.BinaryTree.Node;
import com.skbr.binarytree.BinaryTreeFactory;

public class LevelOrderTraversalSeperateLineOuput {
	
	private static void levelOrderTraversalUsingTwoQueue(Node root) {
		
		if(root == null)
			return;
		
		Queue<Node> queue1 = new LinkedList<Node>();
		Queue<Node> queue2 = new LinkedList<Node>();
		
		queue1.offer(root);
		while(!queue1.isEmpty() || !queue2.isEmpty()) {
			
			while(!queue1.isEmpty()) {
				Node current = queue1.poll();
				System.out.print(current);
				
				if(current.getLeft()!= null)
					queue2.offer(current.getLeft());
				if(current.getRight()!= null)
					queue2.offer(current.getRight());
			}
			System.out.println();

			while(!queue2.isEmpty()) {
				Node current = queue2.poll();
				System.out.print(current);
				
				if(current.getLeft()!= null)
					queue1.offer(current.getLeft());
				if(current.getRight()!= null)
					queue1.offer(current.getRight());
			}
			System.out.println();
			
		}
		
	}
	private static void levelOrderTraversal(Node root) {
		
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
				
				System.out.print(current);
				
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
		levelOrderTraversal(BinaryTreeFactory.getSevenNodeSkewedBinaryTree().getRoot());
		System.out.println("");
		System.out.println("7-node perfect");
		levelOrderTraversal(BinaryTreeFactory.getSevenNodesPerfectBinaryTree().getRoot());
		System.out.println("");
		System.out.println("15-node perfect");
		levelOrderTraversal(BinaryTreeFactory.getPerfectBinaryTree().getRoot());
		
		levelOrderTraversalUsingTwoQueue(BinaryTreeFactory.getPerfectBinaryTree().getRoot());

	}

}
