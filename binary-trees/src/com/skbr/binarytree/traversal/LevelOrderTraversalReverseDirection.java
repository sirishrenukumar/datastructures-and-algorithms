package com.skbr.binarytree.traversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.skbr.binarytree.BinaryTree;
import com.skbr.binarytree.BinaryTree.Node;
import com.skbr.binarytree.BinaryTreeFactory;

public class LevelOrderTraversalReverseDirection {
	
	private static void levelOrderTraversal(Node root) {
		
		Queue<Node> queue = new LinkedList<Node>();
		Stack<Node> stack = new Stack<Node>();
		
		if(root != null) {
			queue.add(root);
		}
		
		while(!queue.isEmpty()) {
			Node current = queue.remove();
			stack.push(current);	

			/*
			 * Add the right and then the left since stack is LIFO and we need to print left to right
			 */
			
			/*
			 * Add the right child of the current node if present
			 */
			if (current.getRight() != null) {
				queue.add(current.getRight());
			}

			/*
			 * Add the left child of the current node if present
			 */
			if (current.getLeft() != null) {
				queue.add(current.getLeft());
			}
		}
		
		while(!stack.empty()) 
			System.out.print(stack.pop() + "->");
	}

	public static void main(String[] args) {

		BinaryTree binaryTree = BinaryTreeFactory.getPerfectBinaryTree();
		levelOrderTraversal(binaryTree.getRoot());

	}

}