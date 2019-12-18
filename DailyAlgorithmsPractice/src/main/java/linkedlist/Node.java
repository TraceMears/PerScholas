package linkedlist;

public class Node {
	Node next;
	Object value;
	
	public Node(Object data) {
		this.value = data;
	}
		
	public Node getNext() {
		if (this.next == null) {
			return null;
		}
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
	public void printNode() {
		System.out.print(this.getValue());
	}
	
}
