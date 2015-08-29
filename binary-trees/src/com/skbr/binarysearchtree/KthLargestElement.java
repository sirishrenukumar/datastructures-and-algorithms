package com.skbr.binarysearchtree;

import com.skbr.binarysearchtree.BinarySearchTree.Node;

public class KthLargestElement {
	
	private static int count = 0;
	
	private static void kThLargestElement(Node root, int k) {
		
		if (root == null || count > k)
			return;
		
		kThLargestElement(root.getRight(), k);
		
		++count;
		if(k == count)
			System.out.println(root.getData());
		
		kThLargestElement(root.getLeft(), k);
	}

	public static void main(String[] args) {
		int nodes [] = new int[] {20,8,22,4,12,10,14};
		BinarySearchTree binarySearchTree = BinarySearchTreeFactory.getBinarySearchTree(nodes);
		
		System.out.println();
		System.out.println("Inorder");
		binarySearchTree.inorder();
		System.out.println();
		System.out.println("Level order");
		binarySearchTree.levelOrder();
		
		for(int i = 1 ; i <= nodes.length ; ++i) {
			count = 0;
			System.out.println(i + " largest element");
			kThLargestElement(binarySearchTree.getRoot(), i);
		}
	}

}
