package com.skbr;

public class StackWithMinMax {
	
	
	private static class StackWithMinAndMaxInEachNode {

		private Node [] stack;
		private int top;
		private int size;
		
		/**
		 * Each node itself stores the min and max as it sees it
		 * @author sirishr
		 *
		 */
		private class Node {
			private int value;
			private int min;
			private int max;
			Node(int value, int min, int max) {
				super();
				this.value = value;
				this.min = min;
				this.max = max;
			}
			int getValue() {
				return value;
			}
			int getMin() {
				return min;
			}
			int getMax() {
				return max;
			}
			@Override
			public String toString() {
				return "[val=" + value + "],[min="+ min + "],[max=" + max +"]";
			}
			
		}
		
		StackWithMinAndMaxInEachNode(int size) {
			stack = new Node[size];
			top = -1;
			this.size = size;
		}
		
		boolean isFull() {
			return top == size - 1;
		}
		boolean isEmpty() {
			return top < 0;
		}
		
		void push(int value) {
			if(isFull())
				return;
			
			int min = Math.min(value, getMin());
			int max = Math.max(value, getMax());
			stack[++top] = new Node(value, min, max);
		}
		int pop() {
			if(isEmpty())
				return -1;
			
			Node node = stack[top];
			stack[top] = null;
			--top;
			
			return node.getValue();
		}
		private int getMin() {
			if(isEmpty())
				return Integer.MAX_VALUE;
			else
				return stack[top].getMin();
		}
		private int getMax() {
			if(isEmpty())
				return Integer.MIN_VALUE;
			else 
				return stack[top].getMax();
		}
		
	
		
	}

	public static void main(String[] args) {
		StackWithMinAndMaxInEachNode stack = new StackWithMinAndMaxInEachNode(5);
		for(int i = 1 ; i <=10; ++i)
			stack.push(i);

		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
	}

}
