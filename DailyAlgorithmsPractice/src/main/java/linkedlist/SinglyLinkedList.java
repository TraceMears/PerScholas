package linkedlist;

public class SinglyLinkedList {
	Node head;
	Node tail;
	int size;
		
	public SinglyLinkedList(Node node) {
		this.head = node;
		this.tail = node;
		this.size = 1;
	}
	public Node getHead() {
		return head;
	}
	public void setHead(Node head) {
		this.head = head;
	}
	public Node getTail() {
		return tail;
	}
	public void setTail(Node tail) {
		this.tail = tail;
	}
	
	public void add(Node n) {
		this.tail.setNext(n);
		tail = n;
		size++;
	}
	
	public void insertAtIndex(Node n, int index) {
		if(this.size<index) {
			System.out.println("Invalid index, out of bounds for Linked List");
			return;
		}
		if(this.size==index) {
			this.add(n);
		}
		
		Node place = head;
		for(int i=0; i<index-1; i++) {
			place = place.getNext();
		}
		Node temp = place.getNext();
		place.setNext(n);
		n.setNext(temp);	
		this.size += 1;
	}
	
	public void insertAfterValue(Node n, Object val) {
		//test if head is the value
		if(this.head.getValue().equals(val)) {
			n.setNext(this.head.getNext());
			this.head.setNext(n);
			this.size += 1;
			return;
		}
		
		Node pointer = this.getHead().getNext();
		while(pointer.getNext() != null) {
			if(pointer.getValue().equals(val)) {
				n.setNext(pointer.getNext());
				pointer.setNext(n);
				this.size += 1;
				return;
			}
			pointer = pointer.getNext();
		}
		if(pointer.getValue().equals(val)) {
			pointer.setNext(n);
			this.size += 1;
			return;
		}
	}
	
	public void deleteValue(Object val) {
		//test if head is the value, just set new head if so
		if(this.head.getValue().equals(val)) {
			this.head = head.getNext();
			this.size -= 1;
			return;
		}
		
		Node pointer = this.getHead();
		while (pointer.getNext() != null) {
			if(pointer.getNext().getValue().equals(val)){
				if(pointer.getNext().getNext() == null) {
					pointer.setNext(null);
					this.size -= 1;
					return;
				}
				pointer.setNext(pointer.getNext().getNext());
				this.size -= 1;
				return;
			}
			pointer = pointer.getNext();
		}				
	}
	
	public Node getMidpoint() {
		int mid = 0;
		if(this.size % 2 == 0) {
			mid = this.size / 2;
		}
		else {
			mid = (this.size / 2) + 1;
		}
		Node ptr = this.head;
		for(int x=1; x<mid; x++) {
			ptr = ptr.getNext();
		}
		return ptr;
	}
	
	public Node getNthFromEnd(int n) {
		if(n>size) {
			System.out.println("Invalid, n is greater than size of the list, returning head instead");
			return this.head;
		}
		int nth = this.size - n + 1;
		
		Node ptr = this.head;
		for(int x=1; x<nth; x++) {
			ptr = ptr.getNext();
		}
		return ptr;		
	}
	
	public void printList() {
		Node pointer = this.getHead();
		pointer.printNode();
		System.out.print(" ");
		while(pointer.getNext() != null) {
			pointer = pointer.getNext();
			pointer.printNode();
			System.out.print(" ");
		}
		System.out.println();
	}
}
