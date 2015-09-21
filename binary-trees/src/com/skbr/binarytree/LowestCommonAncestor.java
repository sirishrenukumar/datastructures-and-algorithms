package com.skbr.binarytree;

import com.skbr.binarytree.BinaryTree.Node;

public class LowestCommonAncestor {

	public static int lca(Node root, int a, int b) {
		
		if(root == null)
			return Integer.MIN_VALUE;
		
		if(root.getData() == a || root.getData() == b) 
			return root.getData();
		
		int left = lca(root.getLeft(), a, b);
		int right = lca(root.getRight(), a, b);
		
		if(left != Integer.MIN_VALUE && right != Integer.MIN_VALUE) 
			return root.getData();
		
		return left != Integer.MIN_VALUE ? left : right;
	}
	
	public static void main(String[] args) {
		
		BinaryTree binaryTree  = BinaryTreeFactory.getPerfectBinaryTree();
		binaryTree.levelorder();
		
		System.out.println();
		System.out.println("LCA for 2 and 3 : " + lca(binaryTree.getRoot(), 2, 3));
		
		System.out.println();
		System.out.println("LCA for 2 and 4 : " + lca(binaryTree.getRoot(), 2, 4));

		System.out.println();
		System.out.println("LCA for 2 and 9 : " + lca(binaryTree.getRoot(), 2, 9));

		System.out.println();
		System.out.println("LCA for 4 and 15 : " + lca(binaryTree.getRoot(), 4, 15));

		System.out.println();
		System.out.println("LCA for 3 and 15 : " + lca(binaryTree.getRoot(), 3, 15));

	}

}
