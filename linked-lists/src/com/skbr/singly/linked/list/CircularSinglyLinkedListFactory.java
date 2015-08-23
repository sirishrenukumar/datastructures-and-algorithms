package com.skbr.singly.linked.list;

public class CircularSinglyLinkedListFactory {
	
	public static CircularSinglyLinkedList<?> getAscendeningOrderSortedCircularList(int size) {
		CircularSinglyLinkedList<Integer> circularSinglyLinkedList = new CircularSinglyLinkedList<Integer>();
		for(int i = 1; i <= size ; ++i) {
			circularSinglyLinkedList.insertAtEnd(i);
		}
		return circularSinglyLinkedList;
	}
}
