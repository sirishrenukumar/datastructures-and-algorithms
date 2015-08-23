package com.skbr.singly.linked.list;

public class CircularSinglyLinkedListMain {

	public static void main(String[] args) {
		CircularSinglyLinkedList<?> circularSinglyLinkedList = CircularSinglyLinkedListFactory.getAscendeningOrderSortedCircularList(5);
		
		System.out.println("Circular Linked List");
		System.out.println(circularSinglyLinkedList);
		
		System.out.println("Contains loop");
		System.out.println(circularSinglyLinkedList.containsLoop());
		System.out.println(new CircularSinglyLinkedList<Integer>().containsLoop());

		System.out.println(CircularSinglyLinkedListFactory.getAscendeningOrderSortedCircularList(1).containsLoop());
		System.out.println(CircularSinglyLinkedListFactory.getAscendeningOrderSortedCircularList(2).containsLoop());
	}

}
