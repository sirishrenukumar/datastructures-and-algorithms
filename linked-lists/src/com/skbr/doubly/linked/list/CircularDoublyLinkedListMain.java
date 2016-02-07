package com.skbr.doubly.linked.list;

public class CircularDoublyLinkedListMain {

	public static void main(String[] args) {
		CircularDoublyLinkedList<Integer> circularDoublyLinkedList = new CircularDoublyLinkedList<>();

		for(int i = 0; i < 10; ++i) 
			circularDoublyLinkedList.insertAtFront(i);
		
		System.out.println(circularDoublyLinkedList);
		
		circularDoublyLinkedList.delete(9);
		System.out.println(circularDoublyLinkedList);
		circularDoublyLinkedList.delete(5);
		System.out.println(circularDoublyLinkedList);
		circularDoublyLinkedList.delete(0);
		System.out.println(circularDoublyLinkedList);
		
	}

}
