
public class DoublyLinkedList<T> {
	private Node<T> header;
	private Node<T> trailor;
	private int size = 0;
	
	public DoublyLinkedList() {
		
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
		Node<T> temp = this.header;
		while (temp != null) {
			res += temp.toString() + " <-> ";
			temp = temp.getNext();
		}
		return res.substring(0, res.length()-5);
	}
	
	public void addFirst(T data) {
		if (isEmpty()) {
			this.header = new Node<T>(data, null, this.header);
			this.trailor = this.header;
			this.size++;
		} else {
			this.header.setPrev(new Node<T>(data, null, this.header));
			this.header = this.header.getPrev();
			this.size++;	
		}
	}
	
	public void addLast(T data) {
		if (isEmpty()) addFirst(data);
		else {
			this.trailor.setNext(new Node<T>(data, this.trailor, null));
			this.trailor = this.trailor.getNext();
			this.size++;
		}
	}
	
	public T removeFirst() {
		if (isEmpty()) return null;
		Node<T> temp = this.header;
		this.header = this.header.getNext();
		if (size() > 1) this.header.setPrev(null);
		temp.setNext(null);
		this.size--;
		return temp.getData();
	}
	
	public T removeLast() {
		if (isEmpty()) return null;
		Node<T> temp = this.trailor;
		this.trailor = this.trailor.getPrev();
		if (size() > 1) this.trailor.setNext(null);
		temp.setPrev(null);
		this.size--;
		return temp.getData();
	}
	
	class Node<T> {
		private T data;
		private Node<T> prev;
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
		
		public Node(T data, Node<T> prev, Node<T> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
		
		public T getData() {
			return this.data;
		}
		
		public void setData(T data) {
			this.data = data;
		}
		
		public Node<T> getPrev() {
			return this.prev;
		}
		
		public void setPrev(Node<T> prev) {
			this.prev = prev;
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
