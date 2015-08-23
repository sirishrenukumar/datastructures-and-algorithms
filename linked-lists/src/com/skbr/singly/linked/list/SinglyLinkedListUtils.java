package com.skbr.singly.linked.list;

import com.skbr.singly.linked.list.SinglyLinkedList.Node;

public class SinglyLinkedListUtils {

	public static SinglyLinkedList add(SinglyLinkedList operand1, SinglyLinkedList operand2) {

		SinglyLinkedList result = new SinglyLinkedList();

		add(operand1.getHead(), operand2.getHead(), result, 0);

		return result;
	}

	private static void add(SinglyLinkedList.Node operand1, SinglyLinkedList.Node operand2, SinglyLinkedList result,
			int carry) {

		if (operand1 == null && operand2 == null) {
			return;
		}

		int o1 = getNullSafeValue(operand1);
		int o2 = getNullSafeValue(operand2);
		int sum = o1 + o2 + carry;
		int unitLocationInSum = sum % 10;
		int carryFromSum = sum >= 10 ? 1 : 0;
		result.insertAtEnd(unitLocationInSum);
		
		Node o1Next = getNullSafeNext(operand1);
		Node o2Next = getNullSafeNext(operand2);
		add(o1Next, o2Next, result, carryFromSum);
	}

	private static Node getNullSafeNext(Node operand) {
		return operand != null ? operand.getNext() : null;
	}

	private static int getNullSafeValue(Node operand) {
		return operand != null ? operand.getData() : 0;
	}

}
