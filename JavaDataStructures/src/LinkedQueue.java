
public class LinkedQueue<T> {
	private Node<T> first;
	private int size = 0;
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public String toString() {
		if (isEmpty()) return null;
		String res = "";
		Node<T> temp = this.first;
		while (temp != null) {
			res += temp.toString() + " > ";
			temp = temp.getNext();
		}
		return res.substring(0, res.length()-3);
	}
	
	public T first() {
		if (isEmpty()) return null;
		return this.first.getData();
	}
	
	public T dequeue() {
		if (isEmpty()) return null;
		Node<T> res = this.first;
		this.first = this.first.getNext();
		res.setNext(null);
		this.size--;
		return res.getData();
	}
	
	public void enqueue(T data) {
		this.first = new Node<T>(data, this.first);
		this.size++;
	}
	
	@SuppressWarnings("hiding")
	class Node<T> {
		private T data;
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
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
