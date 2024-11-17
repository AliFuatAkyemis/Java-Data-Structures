
public class Node<T> implements INode<T> {
	private T data;
	private Node<T> prev;
	private Node<T> next;
	
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
		return "[" + getData() + "]";
	}
}
