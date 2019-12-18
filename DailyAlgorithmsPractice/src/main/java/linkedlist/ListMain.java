package linkedlist;

public class ListMain {

	public static void main(String[] args) {
		Node n = new Node(1);
		SinglyLinkedList list = new SinglyLinkedList(n);
		list.printList();
		System.out.println();
		
		Node n1 = new Node(12);
		list.add(n1);
		list.printList();
		System.out.println();
		
		Node n2 = new Node(true);
		list.add(n2);
		list.printList();
		System.out.println();
		
		Node n3 = new Node(37.9);
		list.add(n3);
		list.printList();
		System.out.println();
		
		Node n4 = new Node("Trace");
		list.add(n4);
		list.printList();
		System.out.println();
		
		Node n5 = new Node(21);
		list.add(n5);
		list.printList();
		System.out.println();
		
		Node n6 = new Node(38);
		list.insertAtIndex(n6, 3);
		list.printList();
		System.out.println();
		
		list.deleteValue(12);
		list.printList();
		System.out.println();
		
		Node n7 = new Node(27.5);
		list.insertAfterValue(n7, true);
		list.printList();
		System.out.println();

		
		list.getMidpoint().printNode();
		System.out.println();
		list.getNthFromEnd(3).printNode();;
	}

}
