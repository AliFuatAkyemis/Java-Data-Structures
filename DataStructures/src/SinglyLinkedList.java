
public class SinglyLinkedList<T> implements ISingly<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size = 0;
	
	public SinglyLinkedList() {
		
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		if (size() == 0) return true;
		return false;
	}
	
	public String toString() {
		if (isEmpty()) return null;
		String response = "";
		Node<T> temp = this.head;
		while (temp != null) {
			response += temp.toString() + " -> ";
			temp = temp.getNext();
		}
		return response + null;
	}
	
	public T first() {
		if (isEmpty()) return null;
		return this.head.getData();
	}
	
	public T last() {
		if (isEmpty()) return null;
		return this.tail.getData();
	}
	
	public void addFirst(T data) {
//		if (isEmpty()) {
//			this.head = new Node(data, null, this.tail);
//			this.tail = this.head;
//			this.size++;
//		} else {
//			this.head = new Node(data, null, this.head);
//			this.size++;
//		}
		this.head = new Node(data, null, this.head);
		if (isEmpty()) this.tail = this.head;
		this.size++;
	}
	
	public void addLast(T data) {
		if (isEmpty()) {
			this.head = new Node(data, null, this.tail);
			this.tail = this.head;
			this.size++;
		}else {
			this.tail.setNext(new Node(data, null, null));
			this.tail = this.tail.getNext();
			this.size++;
		}
	}
	
	public T removeFirst() {
		if (isEmpty()) return null;
		Node<T> temp = this.head;
		this.head = this.head.getNext();
		temp.setNext(null);
		this.size--;
		return temp.getData();
	}
	
	public T removeLast() {
		if (isEmpty()) return null;
		else if (size() == 1) {
			Node<T> temp = this.head;
			this.head = this.head.getNext();
			temp.setNext(null);
			this.size--;
			return temp.getData();
		}
		else {
			Node<T> temp = this.head;
			while (temp.getNext() != this.tail) {
				temp = temp.getNext();
			} 
			this.tail = temp;
			temp = temp.getNext();
			this.tail.setNext(null);
			this.size--;
			return temp.getData();
		}
	}
}