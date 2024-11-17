
public class LinkedQueue<T> implements IQueue<T> {
	private Node<T> first;
	private Node<T> last;
	private int size = 0;
	
	public LinkedQueue() {
		
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		if (this.size == 0) return true;
		return false;
	}
	
	public String toString() {
		if (isEmpty()) return null;
		String response = "";
		Node<T> temp = this.first;
		for (int i = 0;i < size();i++) {
			response += temp.toString() + " > ";
			temp = temp.getNext();
		}
		return response.trim();
	}
	
	public T first() {
		if (isEmpty()) return null;
		return this.first.getData();
	}
	
	public void enqueue(T data) {
		if (isEmpty()) {
			this.first = new Node(data, null, this.last);
			this.last = this.first;
			this.size++;
		} else {
			this.last.setNext(new Node(data, null, null));
			this.last = this.last.getNext();
			this.size++;
		}
	}
	
	public T dequeue() {
		if (isEmpty()) return null;
		Node<T> temp = this.first;
		this.first = this.first.getNext();
		temp.setNext(null);
		this.size--;
		return temp.getData();
	}
}
