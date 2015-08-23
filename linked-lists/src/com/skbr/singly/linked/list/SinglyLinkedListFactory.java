package com.skbr.singly.linked.list;

public class SinglyLinkedListFactory {
	public static SinglyLinkedList getAscendeningOrderSortedList(int size) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
		
		for(int i = 1; i <= size; ++i) {
			singlyLinkedList.insertAtEnd(i);
		}
		return singlyLinkedList;
	}
	public static SinglyLinkedList getAscendeningOrderSortedListWithDuplicates(int distinctItems) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
		
		for(int i = 1; i <= distinctItems; ++i) {
			
			for(int j = 1; j <= i; ++j) {
				singlyLinkedList.insertAtEnd(i);	
			}
		}
		return singlyLinkedList;
	}
}
