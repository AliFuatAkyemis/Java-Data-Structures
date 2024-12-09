
public class ArrayStack<T> {
	private static final int CAPACITY = 1000;
	private T[] array;
	private int t = -1;
	
	public ArrayStack() {
		this(CAPACITY);
	}
	
	public ArrayStack(int capacity) {
		this.array = (T[]) new Object[capacity];
	}
	
	public int size() {
		return this.t+1;
	}
	
	public boolean isEmpty() {
		return this.t+1 == 0;
	}
	
	public String toString() {
		if (isEmpty()) return null;
		String res = "";
		for (int i = this.t;i >= 0;i--) {
			res += "[" + this.array[i].toString() + "]" + "\n | \n";
		}
		return res + "---";
	}
	
	public T top() {
		if (isEmpty()) return null;
		return this.array[this.t];
	}
	
	public T pop() {
		if (isEmpty()) return null;
		T res = this.array[this.t];
		this.array[this.t--] = null;
		return res;
	}
	
	public void push(T data) throws IllegalArgumentException {
		if (this.t == this.array.length-1) throw new IllegalArgumentException("Stack is Full!");
		this.array[++this.t]= data;
	}
}
