package com.skbr.binarytree.bfs.traversal.problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import com.skbr.binarytree.BinaryTree.Node;
import com.skbr.binarytree.BinaryTreeFactory;

public class PrintInVerticalOrder {
	
	private static class QueueItem {
		private Node node;
		private int hd;

		public QueueItem(Node node, int hd) {
			super();
			this.node = node;
			this.hd = hd;
		}

		public Node getNode() {
			return node;
		}

		public int getHd() {
			return hd;
		}
	}

	private static void printVerticalORder(Node root) {
		
		Queue<QueueItem> queue = new LinkedList<QueueItem>();
		
		if(root!= null)
			queue.add(new QueueItem(root, 0));
		
		Map<Integer, List<Integer>> map = new TreeMap<>();
		
		while(!queue.isEmpty()) {
			
			QueueItem queueItem = queue.remove();
			Node current = queueItem.getNode();
			int hd = queueItem.getHd();
			
			addToMap(map,current,hd);
			
			/*
			 * Add the left child of the current node if present and pass HD - 1
			 */
			if (current.getLeft() != null) {
				queue.add(new QueueItem(current.getLeft(), hd - 1));
			}

			/*
			 * Add the right child of the current node if present and pass HD + 1
			 */
			if (current.getRight() != null) {
				queue.add(new QueueItem(current.getRight(), hd + 1));
			}
		}
		
		for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			System.out.println(entry.getValue());
		}
		
		
	}

	private static void addToMap(Map<Integer, List<Integer>> map, Node current, int hd) {
		
		List<Integer> list = map.get(hd);
		
		if(list == null) {
			list = new LinkedList<Integer>();
			list.add(current.getData());
			map.put(hd, list);
		} else {
			list.add(current.getData());
		}
	}

	public static void main(String[] args) {

		System.out.println("");
		System.out.println("7-node skewed");
		printVerticalORder(BinaryTreeFactory.getSevenNodeSkewedBinaryTree().getRoot());
		System.out.println("");
		System.out.println("7-node perfect");
		printVerticalORder(BinaryTreeFactory.getSevenNodesPerfectBinaryTree().getRoot());
		System.out.println("");
		System.out.println("15-node perfect");
		printVerticalORder(BinaryTreeFactory.getPerfectBinaryTree().getRoot());

		
	}

}
