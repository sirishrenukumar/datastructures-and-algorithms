package com.skbr.binarytree.bfs.traversal;

import java.util.Stack;

import com.skbr.binarysearchtree.BinarySearchTree;
import com.skbr.binarysearchtree.BinarySearchTree.Node;
import com.skbr.binarysearchtree.BinarySearchTreeFactory;

public class InOrderIterative {
	
	private static void inorderIterative(Node root) {
		
		if(root == null)
			return;
		
		boolean done = false;
		Stack<Node> stack = new Stack<Node>();
		Node current = root;
		
		while(!done) {
			
			if(current != null) {
				stack.push(current);
				current = current.getLeft();
			}
			else {
				if(stack.isEmpty()) {
					done = true;
				} else {
					current = stack.pop();
					System.out.print(current + ",");
					current = current.getRight();
				}
			}
		}
	}

	public static void main(String[] args) {
		
		BinarySearchTree bst = BinarySearchTreeFactory.getBinarySearchTree(new int [] {10,9,8,7,6,5,4,3,2,1});
		System.out.println();
		System.out.println("Iterative");
		inorderIterative(bst.getRoot());
		System.out.println();
		System.out.println("Recursive");
		bst.inorder();
	}

}
