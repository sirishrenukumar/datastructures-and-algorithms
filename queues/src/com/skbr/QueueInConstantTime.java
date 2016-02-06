package com.skbr;

public class QueueInConstantTime {

	static class Queue<T> {

		private class Node<U> {
			private U value;
			private Node<U> next;

			Node(U value) {
				this.value = value;
			}
		}

		/**
		 * - Maintaining two pointers so that we have O(1) operations in enqueue
		 * and dequeue
		 * 
		 * - Enqueue using the tail pointer and dequeue using the head pointer
		 */
		private Node<T> head;
		private Node<T> tail;

		void enqueue(T value) {
			Node<T> node = new Node<T>(value);

			if (head == null && tail == null) {
				head = tail = node;
			} else {
				tail.next = node;
				tail = node;
			}
		}

		T dequeue() {

			if (head == null)
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
