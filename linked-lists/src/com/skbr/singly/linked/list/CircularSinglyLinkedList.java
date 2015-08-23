package com.skbr.singly.linked.list;

public class CircularSinglyLinkedList<T> {

	private class Node {
		T data;
		Node next;

		Node(T data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return data.toString();
		}
	}

	private Node head;

	public void insertAtEnd(T data) {
		Node node = new Node(data);
		if (head == null) {
			head = node;
			head.next = head;
		} else {
			/*
			 * 	- Start from the first node
			 * 	- Traverse until the last node is reached
			 * 	- Make the last node point to the new node
			 * 	- Make the new last node point to the head node
			 */
			Node current = head;
			while (current.next != head) {
				current = current.next;
			}
			current.next = node;
			node.next = head;
		}
	}
	
	public boolean containsLoop() {
		if(head == null || head.next == head) {
			return false;
		}
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		if (head == null) {
			return "[]";
		} else {
			StringBuilder stringBuilder = new StringBuilder("[");
			Node current = head;
			while (current.next != head) {
				stringBuilder.append(current.data + " -> ");
				current = current.next;
			}
			stringBuilder.append(current.data + " -> ");
			stringBuilder.append("]");
			return stringBuilder.toString();
		}
	}

}
