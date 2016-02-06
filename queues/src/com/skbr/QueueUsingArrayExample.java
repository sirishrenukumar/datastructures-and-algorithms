package com.skbr;

public class QueueUsingArrayExample {
	
	
	static class QueueFullException extends RuntimeException {
		private static final long serialVersionUID = 1L;
	}
	static class QueueEmptyException extends RuntimeException {
		private static final long serialVersionUID = 1L;
	}

	static class Queue<T> {
		
		private T array[];
		private int size;
		private int count;
		private int head;
		private int tail;
		
		@SuppressWarnings("unchecked")
		Queue(int size) {
			this.size = size;
			this.array = (T[])new Object[size];
		}
		
		boolean isFull() {
			return count == size;
		}
		boolean isEmpty() {
			return count == 0;
		}
		
		void enqueue(T value) {
			if(isFull())
				throw new QueueFullException();
			
			array[tail] = value;
			tail = (++tail) % size;
			++count;
		}
		T dequeue() {
			if(isEmpty())
				throw new QueueEmptyException();

			T value = array[head];
			head = (++head) % size;
			--count;
			
			return value;
		}

		@Override
		public String toString() {
			StringBuilder stringBuilder = new StringBuilder();
			
			int index = head;
			for(int i = 0; i < count; ++i) {
				
				stringBuilder.append(array[index] + " ");
				index = (index + 1) % size;
			}
			
			return stringBuilder.toString();
		}
		
		
	}

	public static void main(String[] args) {
		Queue queue = new Queue(3);
		
		for(int i = 0; i < 3; ++i) 
			queue.enqueue("String" + i);
		System.out.println(queue);

		for(int i = 0; i < 3; ++i) 
			System.out.println(queue.dequeue());

		for(int i = 10; i < 13; ++i) 
			queue.enqueue(i);
		System.out.println(queue);
	}

}
