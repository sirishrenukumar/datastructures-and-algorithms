package com.skbr.singly.linked.list;

public class SinglyLinkedListMain {

	public static void main(String[] args) {
		SinglyLinkedList singlyLinkedList = SinglyLinkedListFactory.getAscendeningOrderSortedListWithDuplicates(11);

		System.out.println("Original list");
		System.out.println(singlyLinkedList);
		
		System.out.println("Remove duplicates");
		singlyLinkedList.removeDuplicatesFromSortedList();
		System.out.println(singlyLinkedList);
		
		System.out.println("Swap adjacent nodes");
		singlyLinkedList.swapAdjacentNodes();
		System.out.println(singlyLinkedList);

		System.out.println("Swap back adjacent nodes using recursion");
		singlyLinkedList.swapAdjacentNodesRecursive();
		System.out.println(singlyLinkedList);
		
		System.out.println("Move last to front 4 times");
		singlyLinkedList.moveLastNodeToFirst();
		singlyLinkedList.moveLastNodeToFirst();
		singlyLinkedList.moveLastNodeToFirst();
		singlyLinkedList.moveLastNodeToFirst();
		System.out.println(singlyLinkedList);
		
		System.out.println("Strip alternate nodes");
		singlyLinkedList.deleteAlternate();
		System.out.println(singlyLinkedList);

		SinglyLinkedList singlyLinkedList1 = SinglyLinkedListFactory.getAscendeningOrderSortedList(5);
		SinglyLinkedList singlyLinkedList2 = SinglyLinkedListFactory.getAscendeningOrderSortedList(3);
		System.out.println("Two linked lists are identical");
		System.out.println(singlyLinkedList1);
		System.out.println(singlyLinkedList2);
		System.out.println(singlyLinkedList1.isIdentical(singlyLinkedList2));
		
		SinglyLinkedList singlyLinkedList3 = SinglyLinkedListFactory.getAscendeningOrderSortedList(5);
		System.out.println(singlyLinkedList3);
		System.out.println("Reverse");
		singlyLinkedList3.reverse();
		System.out.println(singlyLinkedList3);
		System.out.println("Reverse again");
		singlyLinkedList3.reverse();
		System.out.println(singlyLinkedList3);
		System.out.println("Reverse again recursively");
		singlyLinkedList3.reverseRecursive();
		System.out.println(singlyLinkedList3);

		System.out.println("Rotate anti clockwise by 3");
		singlyLinkedList3.rotateAntiClockwise(3);
		System.out.println(singlyLinkedList3);
		System.out.println("Rotate anti clockwise by 2");
		singlyLinkedList3.rotateAntiClockwise(2);
		System.out.println(singlyLinkedList3);

		
		SinglyLinkedList o1 = SinglyLinkedListFactory.getAscendeningOrderSortedList(5);
		SinglyLinkedList o2 = SinglyLinkedListFactory.getAscendeningOrderSortedList(2);
		System.out.println("Adding 2 lists");
		SinglyLinkedList result = SinglyLinkedListUtils.add(o1, o2);
		o1.reverse();
		o2.reverse();
		System.out.println(o1);
		System.out.println(o2);
		result.reverse();
		System.out.println(result);
	}

}
