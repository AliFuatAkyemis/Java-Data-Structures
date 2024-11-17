
public class ArrayStack<T> implements IStack<T> {
	private static final int CAPACITY = 1000;
	private T[] data;
	private int t = -1;
	
	public ArrayStack() {
		this(CAPACITY);
	}
	
	public ArrayStack(int capacity) {
		this.data = (T[]) new Object[capacity];
	}
	
	public int size() {
		return this.t+1;
	}
	
	public boolean isEmpty() {
		if (size() == 0) return true;
		return false;
	}
	
	public String toString() {
		if (isEmpty()) return null;
		String response = "";
		for (int i = this.t;i >= 0;i--) {
			response += "[" + data[i] + "]" + "\n | \n";
		}
		return response.trim();
	}
	
	public T top() {
		if (isEmpty()) return null;
		return data[this.t];
	}
	
	public void push(T element) throws IllegalArgumentException {
		if (size() == data.length) throw new IllegalArgumentException("Stack is Full!");
		data[++this.t] = element;
	}
	
	public T pop() {
		if (isEmpty()) return null;
		T temp = data[t];
		data[t] = null;
		t--;
		return temp;
	}
}
