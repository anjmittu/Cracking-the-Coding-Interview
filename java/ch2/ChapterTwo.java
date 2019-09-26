package ch2;


public class ChapterTwo {
	/*
	Remove Dups: Write code to remove duplicates from an unsorted linked list. FOLLOW UP How would you solve this problem if   a temporary buffer is   not allowed?
	*/
	public static LinkedListNode removeDups(LinkedListNode n) {
		LinkedListNode current_node = n;
		LinkedListNode faster_node = current_node.next;
		int current_value;
		while (current_node != null) {
			current_value = current_node.data;
			while (faster_node != null) {
				if (current_value == faster_node.data) {
					// Remove node
					faster_node.prev.next = faster_node.next;
					if (faster_node.next != null) {
						faster_node.next.prev = faster_node.prev;
					}
				}
				faster_node = faster_node.next;
			}
			current_node = current_node.next;
			if (current_node != null) {
				faster_node = current_node.next;
			}
		}
		return n;
	}

	public static void testremoveDups() {
		LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
		LinkedListNode head = first;
		LinkedListNode second = first;
		for (int i = 1; i < 8; i++) {
			second = new LinkedListNode(i % 2, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		System.out.println(head.printForward());

		LinkedListNode resultA = removeDups(head);

		System.out.println(resultA.printForward());

	}

	/*
	Return  Kth to Last: Implement an algorithm to find the kth to  last element of a singly linked  list.
	*/
	public static int kthToLast(LinkedListNode n, int i) {
		// Get size of list
		int sizeOfList = 0;
		LinkedListNode current = n;
		while (current != null) {
			sizeOfList++;
			current = current.next;
		}
		int front_index = sizeOfList - i;
		current = n;
		while (front_index !=0) {
			current = current.next;
			front_index--;
		}
		return current.data;
	}

	public static void testKthToLast() {
		LinkedListNode head = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
		head.setNext(new LinkedListNode(1));
		LinkedListNode current = head.next;
		current.setNext(new LinkedListNode(2));
		current = current.next;
		current.setNext(new LinkedListNode(4));
		current = current.next;
		current.setNext(new LinkedListNode(7));
		current = current.next;
		current.setNext(new LinkedListNode(8));
		current = current.next;

		System.out.println(head.printForward());

		if (kthToLast(head, 2) == 7) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
		if (kthToLast(head, 1) == 8) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
		if (kthToLast(head, 6) == 0) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}

	}

	public static void main(String[] args) {
		System.out.println("Remove Dups");
		testremoveDups();
		System.out.println("kthToLast");
		testKthToLast();
	}

}

public class LinkedListNode {
	public LinkedListNode next;
	public LinkedListNode prev;
	public LinkedListNode last;
	public int data;
	public LinkedListNode(int d, LinkedListNode n, LinkedListNode p) {
		data = d;
		setNext(n);
		setPrevious(p);
	}

	public LinkedListNode(int d) {
		data = d;
	}

	public LinkedListNode() { }

	public void setNext(LinkedListNode n) {
		next = n;
		if (this == last) {
			last = n;
		}
		if (n != null && n.prev != this) {
			n.setPrevious(this);
		}
	}

	public void setPrevious(LinkedListNode p) {
		prev = p;
		if (p != null && p.next != this) {
			p.setNext(this);
		}
	}

	public String printForward() {
		if (next != null) {
			return data + "->" + next.printForward();
		} else {
			return ((Integer) data).toString();
		}
	}

	public LinkedListNode clone() {
		LinkedListNode next2 = null;
		if (next != null) {
			next2 = next.clone();
		}
		LinkedListNode head2 = new LinkedListNode(data, next2, null);
		return head2;
	}
}
