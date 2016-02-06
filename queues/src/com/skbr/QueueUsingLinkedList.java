package com.skbr;

public class QueueUsingLinkedList {
	
	static class Queue<T> {
		
		static class Node<U> {
			U value;
			Node<U> next;
			
			Node(U value) {
				this.value = value;
			}
		}
		
		private Node<T> head;
		
		void enqueue(T value) {
			Node<T> node = new Node<T>(value);
			
			if(head == null) {
				head = node;
			} else {
				Node<T> current = head;
				while(current.next != null)
					current = current.next;
				current.next = node;
			}
		}
		T dequeue() {
			if(head == null)
				return null;
			
			T value = head.value;
			head = head.next;
			return value;
		}
		@Override
		public String toString() {
			if (head == null)
				return "";
			StringBuilder stringBuilder = new StringBuilder();
			Node<T> current = head;
			while (current != null) {
				stringBuilder.append(current.value + " ");
				current = current.next;
			}

			return stringBuilder.toString();
		}
	}

	public static void main(String[] args) {

		Queue<Integer> queue = new Queue<>();

		for (int i = 0; i < 10; ++i)
			queue.enqueue(i);

		System.out.println(queue);

		for (int i = 0; i < 10; ++i)
			System.out.println(queue.dequeue());

	}

}
