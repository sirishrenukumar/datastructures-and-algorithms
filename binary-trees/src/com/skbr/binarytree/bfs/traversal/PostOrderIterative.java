package com.skbr.binarytree.bfs.traversal;

import java.util.Stack;

import com.skbr.binarytree.BinaryTree;
import com.skbr.binarytree.BinaryTree.Node;
import com.skbr.binarytree.BinaryTreeFactory;

public class PostOrderIterative {
	
	private static void postorderIterative(Node root) {
		
		if(root == null)
			return;
		
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		Node current = root;
		
		stack1.push(current);
		while(!stack1.isEmpty()) {
			
			current = stack1.pop();
			stack2.push(current);

			if(current.getLeft() != null)
				stack1.push(current.getLeft());

			if(current.getRight() != null)
				stack1.push(current.getRight());

		}
		
		while(!stack2.isEmpty()) {
			current = stack2.pop();
			System.out.print(current + ",");
		}
	}

	public static void main(String[] args) {
		
		BinaryTree binaryTree = BinaryTreeFactory.getSevenNodesPerfectBinaryTree();
		System.out.println();
		System.out.println("Iterative");
		postorderIterative(binaryTree.getRoot());
		System.out.println();
		System.out.println("Recursive");
		binaryTree.postorder();
	}

}
