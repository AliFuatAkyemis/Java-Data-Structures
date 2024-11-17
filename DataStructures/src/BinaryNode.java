
public class BinaryNode<T> implements IBinaryNode<T> {
	private T data;
	private BinaryNode<T> left;
	private BinaryNode<T> right;
	
	public BinaryNode(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public T getData() {
		return this.data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public BinaryNode<T> getLeft() {
		return this.left;
	}
	
	public void setLeft(BinaryNode<T> left) {
		this.left = left;
	}
	
	public BinaryNode<T> getRight() {
		return this.right;
	}
	
	public void setRight(BinaryNode<T> right) {
		this.right = right;
	}
	
	public String toString() {
		return "[" + getData() + "]";
	}
}
