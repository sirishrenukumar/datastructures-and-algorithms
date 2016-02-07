package com.skbr.doubly.linked.list;

public class CircularDoublyLinkedList<T> {

	static class Node<U> {
		private U value;
		private Node<U> prev;
		private Node<U> next;

		Node(U value) {
			this.value = value;
			this.prev = this;
			this.next = this;
		}
	}

	private Node<T> head;

	void insertAtFront(T value) {
		Node<T> node = new Node<T>(value);

		if (head == null)
			head = node;
		else {
			Node<T> tail = head.prev;
			node.next = head;
			head.prev = node;
			tail.next = node;
			node.prev = tail;
			head = node;
		}
	}
	boolean delete(T value) {
		if(head == null)
			return false;
		
		//first node match
		if(head.value.equals(value)) {
			Node<T> tail = head.prev;
			head = head.next;
			tail.next = head;
			head.prev = tail;
			return true;
		}
		
		Node<T> current = head;
		while(current.next != head) {
			if(current.value.equals(value)) 
				break;
			
			current = current.next;
		}
		
		if(current.next == head && current.value.equals(value)) {
			//last node match
			current.prev.next = head;
			head.prev = current.prev;
			return true;
			
		} else if (current.value.equals(value)) {
			
			current.prev.next = current.next;
			current.next.prev = current.prev;
			return true;
		}
			
		return false;
	}

	@Override
	public String toString() {
		if (head == null)
			return "";
		else {
			StringBuilder stringBuilder = new StringBuilder();
			Node<T> current = head;
			while (current.next != head) {
				stringBuilder.append(current.value + " ");
				current = current.next;
			}
			stringBuilder.append(current.value + " ");
			return stringBuilder.toString();
		}
	}

}
