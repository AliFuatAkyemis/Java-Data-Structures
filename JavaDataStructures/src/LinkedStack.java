
public class LinkedStack<T> {
	private Node<T> top;
	private int size = 0;
	
	public LinkedStack() {
		
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
		Node<T> temp = this.top;
		while (temp != null) {
			res += temp.toString() + "\n | \n";
			temp = temp.getNext();
		}
		return res + "---";
	}
	
	public T top() {
		if (isEmpty()) return null;
		return this.top.getData();
	}
	
	public T pop() {
		if (isEmpty()) return null;
		Node<T> del = this.top;
		this.top = this.top.getNext();
		del.setNext(null);
		this.size--;
		return del.getData();
	}
	
	public void push(T data) {
		this.top = new Node<T>(data, this.top);
		this.size++;
	}
	
	class Node<T> {
		private T data;
		private Node<T> next;
		
		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
		
		public Node(T data) {
			this.data = data;
			this.next = null;
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
