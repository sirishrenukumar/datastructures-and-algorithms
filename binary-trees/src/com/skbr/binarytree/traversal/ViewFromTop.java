package com.skbr.binarytree.traversal;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import com.skbr.binarytree.BinaryTree;
import com.skbr.binarytree.BinaryTree.Node;
import com.skbr.binarytree.BinaryTreeFactory;

public class ViewFromTop {

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

	private static void topView(Node root) {

		/*
		 * - Logic is to do a Level order/BFS traversal of the tree - At each
		 * node, compute the horizontal distance (HD) of the node from the
		 * origin i.e the line that passes through the entire tree root. - Only
		 * add the first node for each distinct value of the HD. - The rest of
		 * the nodes with the same HD occur below this node and will be hidden -
		 * HD of left child is HD of node - 1 and HD of right child is HD of node
		 * + 1
		 */

		Queue<QueueItem> queue = new LinkedList<QueueItem>();
		Map<Integer,Node> map = new TreeMap<Integer,Node>();

		/*
		 * HD of the root is 0
		 */
		if (root != null) {
			queue.add(new QueueItem(root, 0));
		}

		while (!queue.isEmpty()) {

			QueueItem queueItem = queue.remove();
			Node current = queueItem.getNode();
			int hd = queueItem.getHd();

			/*
			 * If this HD is the first to be encountered, this is a top node and hence will be displayed
			 */
			if (!map.containsKey(hd)) {
				map.put(hd, current);
			}

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
		for(Map.Entry<Integer, Node> entry: map.entrySet()) {
			System.out.print(entry.getValue() + "->");
		}
	}

	public static void main(String[] args) {

		BinaryTree binaryTree = BinaryTreeFactory.getPerfectBinaryTree();
		topView(binaryTree.getRoot());
	}
}
