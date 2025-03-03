
public class CircularLinkedList<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size = 0;
	
	public CircularLinkedList() {
		
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public String toString() {
		if (isEmpty()) return null;
		String res = "";
		Node<T> temp = this.head;
		do {
			res += temp.toString() + " -> ";
			temp = temp.getNext();
		} while (temp != this.head);
		return res + "| " + temp.toString();
	}
	
	public void addFirst(T data) {
		this.head = new Node<T>(data, this.head);
		if (isEmpty()) {
			this.tail = this.head;
			this.head.setNext(this.tail);
		}
		else this.tail.setNext(this.head);
		this.size++;
	}
	
	public void addLast(T data) {
		if (isEmpty()) addFirst(data);
		else {
			this.tail.setNext(new Node<T>(data, this.head));
			this.tail = this.tail.getNext();
			this.size++;
		}
	}
	
	public T removeFirst() {
		if (isEmpty()) return null;
		Node<T> temp = this.head;
		this.head = this.head.getNext();
		this.tail.setNext(this.head);
		temp.setNext(null);
		this.size--;
		if (this.size == 0) {
			this.head = null;
			this.tail = null;
		}
		return temp.getData();
	}
	
	public void rotate() {
		if (isEmpty()) return;
		this.tail = this.head;
		this.head = this.head.getNext();
	}
	
	@SuppressWarnings("hiding")
	class Node<T> {
		private T data;
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
			this.next = null;
		}
		
		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
		
		public T getData() {
			return this.data;
		}
		
		public void setData(T data) {
			this.data = data;
		}
		
		public Node<T> getNext() {
			return this.next;
		}
		
		public void setNext(Node<T> next) {
			this.next = next;
		}
		
		public String toString() {
			return "[" + this.data.toString() + "]";
		}
	}
}
