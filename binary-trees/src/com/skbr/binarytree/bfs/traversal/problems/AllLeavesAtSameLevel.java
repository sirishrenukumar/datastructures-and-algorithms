package com.skbr.binarytree.bfs.traversal.problems;

import java.util.LinkedList;
import java.util.Queue;

public class AllLeavesAtSameLevel {
	
	private static class BinaryTreeNode {
		int data;
		BinaryTreeNode left;
		BinaryTreeNode right;
		BinaryTreeNode(int data) {
			super();
			this.data = data;
		}
		@Override
		public String toString() {
			return "[" + data + "]";
		}
		
		
	}
	private static void levelOrder(BinaryTreeNode root) {

		
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();

		if(root == null)
			return;
		
		
		queue.offer(root);
		queue.offer(null);
		while(!queue.isEmpty()) {
			
			BinaryTreeNode current = queue.poll();
			if(current != null) {
				System.out.print(current + ",");
		
				if(current.left != null)
					queue.offer(current.left);
				if(current.right != null)
					queue.offer(current.right);
			} else {
				
				/*
				 * If there are more levels to traverse and a leaf has already been found, then the whole algorithm return false
				 */
				if(!queue.isEmpty()) {
					queue.offer(null);
					System.out.println();
				}
			}
		}
	}
	private static boolean allLeavesAtSameLevel(BinaryTreeNode root) {
		
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();

		if(root == null)
			return false;
		
		boolean leafFound = false;
		
		queue.offer(root);
		queue.offer(null);
		while(!queue.isEmpty()) {
			
			BinaryTreeNode current = queue.poll();
			
			if(current != null) {
		
				/*
				 * Check if a leaf is found
				 */
				if(!leafFound && (current.left == null && current.right == null))
					leafFound = true;
				
				if(current.left != null)
					queue.offer(current.left);
				if(current.right != null)
					queue.offer(current.right);
			} else {
				
				/*
				 * If there are more levels to traverse and a leaf has already been found, then the whole algorithm return false
				 */
				if(!queue.isEmpty()) {
					if(leafFound)
						return false;
					queue.offer(null);
				}
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		
		BinaryTreeNode binaryTreeNode = new BinaryTreeNode(1);
		binaryTreeNode.left = new BinaryTreeNode(2);
		binaryTreeNode.right = new BinaryTreeNode(3);
		
		levelOrder(binaryTreeNode);

		System.out.println();
		System.out.println("All leaves on same level : " + allLeavesAtSameLevel(binaryTreeNode));

		binaryTreeNode.left.left = new BinaryTreeNode(4);
		
		levelOrder(binaryTreeNode);

		System.out.println();
		System.out.println("All leaves on same level : " + allLeavesAtSameLevel(binaryTreeNode));

		binaryTreeNode.left.right = new BinaryTreeNode(5);
		binaryTreeNode.right.left = new BinaryTreeNode(6);
		
		levelOrder(binaryTreeNode);

		System.out.println();
		System.out.println("All leaves on same level : " + allLeavesAtSameLevel(binaryTreeNode));
		
		System.out.println();
		System.out.println("All leaves on same level : " + allLeavesAtSameLevel(binaryTreeNode));

		binaryTreeNode.left.left.left = new BinaryTreeNode(7);
		
		levelOrder(binaryTreeNode);

		System.out.println();
		System.out.println("All leaves on same level : " + allLeavesAtSameLevel(binaryTreeNode));
	}

}
