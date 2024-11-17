
public class LinkedStack<T> implements IStack<T> {
	private Node<T> top;
	private int size = 0;
	
	public LinkedStack() {
		
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
		Node<T> temp = this.top;
		for (int i = 0;i < size();i++) {
			response += temp.toString() + "\n | \n";
			temp = temp.getNext();
		}
		return response.trim();
	}
	
	public T top() {
		if (isEmpty()) return null;
		return this.top.getData();
	}
	
	public void push(T data) {
		this.top = new Node(data, null, this.top);
		this.size++;
	}
	
	public T pop() {
		if (isEmpty()) return null;
		Node<T> temp = this.top;
		this.top = this.top.getNext();
		temp.setNext(null);
		this.size--;
		return temp.getData();
	}
}