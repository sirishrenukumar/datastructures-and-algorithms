package com.skbr.singly.linked.list;

import com.sun.org.apache.regexp.internal.recompile;

public class SinglyLinkedList {

	public class Node {
		private int data;
		private Node next;

		Node(int data) {
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public Node getNext() {
			return next;
		}

		@Override
		public String toString() {
			return String.valueOf(data);
		}
	}

	private Node head;

	public SinglyLinkedList.Node getHead() {
		return head;
	}

	public void insertAtEnd(int data) {
		Node node = new Node(data);
		if (head == null) {
			head = node;
		} else {
			/*
			 * - Start from the first node - Traverse until the last node is
			 * reached - Make the last node point to the new node
			 */
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = node;
		}
	}

	/**
	 * Remove duplicates from the sorted list (assumption is that the list is
	 * sorted in ascending order)
	 */
	public void removeDuplicatesFromSortedList() {
		if (head == null) {
			return;
		} else {

			/*
			 * Let both pointers point to the same node
			 */
			Node previous = head;
			Node current = head;

			/*
			 * Infinite loop for controlling the single pass
			 */
			while (true) {

				/*
				 * As long as the current node is not NULL and the previous node
				 * has the same data as the current node, keep moving forward
				 */
				while (current != null && previous.data == current.data) {
					current = current.next;
				}

				/*
				 * If the while loop has broken and the current node is not
				 * null, then it indicates that we have moved to a node which
				 * contains a different number. Also there are still other nodes
				 * to process
				 */
				if (current != null) {
					/*
					 * Skip past all the intermediate nodes. Directly make the
					 * previous node point to the current node. Then move the
					 * previous node to the new current
					 */
					previous.next = current;
					previous = current;
				} else {

					/*
					 * End of the list reached. Drop all the nodes between
					 * previous node and the end of the list
					 */
					previous.next = null;
					return;
				}
			}
		}
	}

	public void removeDuplicatesFromUnsortedList() {

		/*
		 * There are 2 methods
		 * 
		 * - Sort the list and then remove the duplicates using the previous
		 * algorithm. The original order of the list is not preserved. Mergesort
		 * can be used in O(nlogn) and then the previous remove algorithm in
		 * O(n)
		 * 
		 * - Else use hashing. Time complexity is O(n) and space complexity is
		 * O(n) as well (for the hashmap)
		 */
	}

	public void moveLastNodeToFirst() {

		/*
		 * Return for empty list or list with single node
		 */
		if (head == null || head.next == null) {
			return;
		} else {
			Node previous = head;
			Node current = head.next;

			/*
			 * Move until the end of the list
			 */
			while (current.next != null) {
				previous = current;
				current = current.next;
			}

			/*
			 * Set the second last node to point to null, make the last node to
			 * point to the first node and then reset head
			 */
			previous.next = null;
			current.next = head;
			head = current;

		}
	}

	public void swapAdjacentNodes() {

		/*
		 * NOP in case of empty list or with single node
		 */
		if (head == null || head.next == null) {
			return;
		} else {
			Node previous = head;
			Node current = head.next;

			while (current != null) {

				/*
				 * Swap the adjacent node contents
				 */
				int temp = previous.data;
				previous.data = current.data;
				current.data = temp;

				/*
				 * Move both references to the next pair
				 */
				previous = current.next;
				current = current.next != null ? current.next.next : null;
			}
		}
	}

	public void swapAdjacentNodesByLinks() {

		/*
		 * NOP in case of empty list or with single node
		 */
		if (head == null || head.next == null) {
			return;
		} else {
			Node first = head;
			Node second = head.next;
			
			while(second != null) {
				Node temp = second.next;
				second.next = first;
				first.next = temp;

				
			}
			
			
		}
	}

	public void swapAdjacentNodesRecursive() {
		swapAdjacentNodesRecursive(head, head.next);
	}

	private void swapAdjacentNodesRecursive(SinglyLinkedList.Node first, SinglyLinkedList.Node second) {

		/*
		 * Terminal condition when any one of the pair of nodes is null
		 */
		if (first == null || second == null) {
			return;
		}

		/*
		 * Swap
		 */
		int temp = first.data;
		first.data = second.data;
		second.data = temp;

		/*
		 * Move to the next pair and make recursive call
		 */
		swapAdjacentNodesRecursive(second.next, second.next != null ? second.next.next : null);
	}

	public void deleteAlternate() {

		/*
		 * Return in case of empty list or single node
		 */
		if (head == null || head.next == null) {
			return;
		} else {
			/*
			 * List has more than one node. Have 2 pointers - first (trailing)
			 * and second (leading)
			 */
			Node first = head;
			Node second = head.next;

			/*
			 * Skip past second node and link to next node. Advance first and
			 * second
			 */
			while (first != null && second != null) {
				first.next = second.next;
				first = second.next;
				second = second.next != null ? second.next.next : null;
			}
		}
	}

	public boolean isIdentical(SinglyLinkedList other) {

		return isIdentical(head, (SinglyLinkedList.Node) other.head);
	}

	public boolean isIdentical(Node left, Node right) {

		if (left == null && right == null) {
			return true;
		} else if (left != null && right != null) {
			return left.data == right.data && isIdentical(left.next, right.next);
		}
		return false;
	}

	public void reverse() {

		/*
		 * NOP in case of empty list or single node list
		 */
		if (head == null || head.next == null) {
			return;
		}

		/*
		 * More than one node in the list. Current starts from the head
		 */
		Node previous = null;
		Node current = head;

		/*
		 * At each step do the following
		 * 
		 * - Store the next node in a temp variable - Make current.next point
		 * back to previous node - Advance previous to the current - Advance
		 * current to the original next node (from temp variable)
		 */
		while (current != null) {
			Node next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}

		/*
		 * Fix the head
		 */
		head = previous;
	}

	public void reverseNodesInGroup(int groupSize) {

		// TODO
	}
	
	public void reverseRecursive() {
		
		head = reverseRecursive(null, head);
	}
	private Node reverseRecursive(Node previous, Node current) {
		
		if(current == null || current.next == null)
			return current;
		
		Node next = current.next;
		current.next = previous;
		
		return reverseRecursive(current, next);
	}

	public void rotateAntiClockwise(int steps) {

		/*
		 * Consider the following list
		 * 
		 * 1 -> 2 -> 3 -> 4 -> 5
		 * 
		 * On rotate by 2, the list should be
		 * 
		 * 3 -> 4 -> 5 -> 1 -> 2
		 * 
		 * Three actions have to be done - Determine the new head node - Set the
		 * last node to point to the starting portion - Set the new last node to
		 * point to null
		 */
		if (head == null || head.next == null) {
			return;
		}

		/*
		 * Traverse 'steps' number of nodes
		 */
		Node previous = null;
		Node current = head;
		int i = 0;
		while (i < steps && current != null) {
			previous = current;
			current = current.next;
			++i;
		}

		/*
		 * At this point, previous node points to the new last node. Set the
		 * next to null
		 */
		previous.next = null;

		/*
		 * At this point we are at the new head node. Traverse until the last
		 * node
		 */
		Node end = current;
		while (end.next != null) {
			end = end.next;
		}

		/*
		 * Set the end node to point to the starting portion
		 */
		end.next = head;

		/*
		 * Set the new head node
		 */
		head = current;

	}

	@Override
	public String toString() {
		if (head == null) {
			return "[]";
		} else {
			StringBuilder stringBuilder = new StringBuilder("[");
			Node current = head;
			while (current != null) {
				stringBuilder.append(current.data + " -> ");
				current = current.next;
			}
			stringBuilder.append("]");
			return stringBuilder.toString();
		}
	}
}
