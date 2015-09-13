package com.skbr.binarytree.bfs.traversal;

import java.util.Stack;

import com.skbr.binarytree.BinaryTree.Node;
import com.skbr.binarytree.BinaryTreeFactory;

public class LevelOrderTraversalSpiralForm {

	private static void levelOrderTraversalSpiralForm(Node root) {

		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();

		if (root != null)
			stack1.push(root);

		while (!stack1.isEmpty() || !stack2.isEmpty()) {

			while (!stack1.isEmpty()) {
				Node current = stack1.pop();
				System.out.print(current.getData() + ",");

				if (current.getLeft() != null)
					stack2.push(current.getLeft());

				if (current.getRight() != null)
					stack2.push(current.getRight());
			}

			while (!stack2.isEmpty()) {
				Node current = stack2.pop();
				System.out.print(current.getData() + ",");

				if (current.getRight() != null)
					stack1.push(current.getRight());

				if (current.getLeft() != null)
					stack1.push(current.getLeft());
			}
		}
	}

	public static void main(String[] args) {

		System.out.println("");
		System.out.println("7-node skewed");
		levelOrderTraversalSpiralForm(BinaryTreeFactory.getSevenNodeSkewedBinaryTree().getRoot());
		System.out.println("");
		System.out.println("7-node perfect");
		levelOrderTraversalSpiralForm(BinaryTreeFactory.getSevenNodesPerfectBinaryTree().getRoot());
		System.out.println("");
		System.out.println("15-node perfect");
		levelOrderTraversalSpiralForm(BinaryTreeFactory.getPerfectBinaryTree().getRoot());

	}

}
