
public class DoublyLinkedList<T> implements IDoubly<T> {
	private Node<T> header;
	private Node<T> trailor;
	private int size = 0;
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		if (size() == 0) return true;
		return false;
	}
	
	public String toString() {
		if (isEmpty()) return null;
		String response = "null <-> ";
		Node<T> temp = this.header;
		while (temp != null) {
			response += temp.toString() + " <-> ";
			temp = temp.getNext();
		}
		return response + null;
	}
	
	public T first() {
		if (isEmpty()) return null;
		return this.header.getData();
	}
	
	public T last() {
		if (isEmpty()) return null;
		return this.trailor.getData();
	}
	
	public void addFirst(T data) {
		if (isEmpty()) {
			this.header = new Node(data, null, this.trailor);
			this.trailor = this.header;
			this.size++;
		} else {
			this.header.setPrev(new Node(data, null, this.header));
			this.header = this.header.getPrev();
			this.size++;
		}
	}
	
	public void addLast(T data) {
		if (isEmpty()) {
			this.header = new Node(data, null, null);
			this.trailor = this.header;
			this.size++;
		} else {
			this.trailor.setNext(new Node(data, this.trailor, null));
			this.trailor = this.trailor.getNext();
			this.size++;
		}
	}
	
	public T removeFirst() {
		if (isEmpty()) return null;
		else if (size() == 1) {
			Node<T> temp = this.header;
			this.header = this.header.getNext();
			temp.setNext(null);
			this.size--;
			return temp.getData();
		}
		else {
			Node<T> temp = this.header;
			this.header = this.header.getNext();
			this.header.setPrev(null);
			temp.setNext(null);
			this.size--;
			return temp.getData();
		}
	}
	
	public T removeLast() {
		if (isEmpty()) return null;
		else if (size() == 1) {
			Node<T> temp = this.header;
			this.header = this.header.getNext();
			temp.setNext(null);
			this.size--;
			return temp.getData();
		}
		else {
			Node<T> temp = this.trailor;
			this.trailor = this.trailor.getPrev();
			this.trailor.setNext(null);
			temp.setPrev(null);
			this.size--;
			return temp.getData();
		}
	}
	
	public void insert(T data, Node<T> predecessor, Node<T> successor) {
		Node<T> newNode = new Node(data, predecessor, successor);
		predecessor.setNext(newNode);
		successor.setPrev(newNode);
		this.size++;
	}
}
