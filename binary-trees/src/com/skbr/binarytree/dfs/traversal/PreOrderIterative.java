package com.skbr.binarytree.dfs.traversal;

import java.util.Stack;

import com.skbr.binarytree.BinaryTree;
import com.skbr.binarytree.BinaryTree.Node;
import com.skbr.binarytree.BinaryTreeFactory;

public class PreOrderIterative {
	
	private static void preorderIterative(Node root) {
		
		if(root == null)
			return;
		
		Stack<Node> stack = new Stack<Node>();
		Node current = root;
		
		stack.push(current);
		while(!stack.isEmpty()) {
			
			current = stack.pop();
			System.out.print(current + ",");

			if(current.getRight() != null)
				stack.push(current.getRight());

			if(current.getLeft() != null)
				stack.push(current.getLeft());
		}
	}

	public static void main(String[] args) {
		
		BinaryTree binaryTree = BinaryTreeFactory.getSevenNodesPerfectBinaryTree();
		System.out.println();
		System.out.println("Iterative");
		preorderIterative(binaryTree.getRoot());
		System.out.println();
		System.out.println("Recursive");
		binaryTree.preorder();
	}

}
