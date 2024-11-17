
public class ArrayQueue<T> implements IQueue<T> {
	private static final int CAPACITY = 1000;
	private T[] data;
	private int f = 0;
	private int sz = 0;
	
	public ArrayQueue() {
		this(CAPACITY);
	}
	
	public ArrayQueue(int capacity) {
		this.data = (T[]) new Object[capacity];
	}
	
	public int size() {
		return this.sz;
	}
	
	public boolean isEmpty() {
		return this.sz == 0;
	}
	
	public String toString() {
		if (isEmpty()) return null;
		String response = "";
		for (int i = f;i < this.f+this.sz;i++) {
			response += "[" + this.data[i] + "]" + " > ";
			i = (i == this.data.length-1) ? -1 : i;
		}
		return response;
	}
	
	public T first() {
		if (isEmpty()) return null;
		return this.data[this.f];
	}
	
	public void enqueue(T element) throws IllegalArgumentException {
		if(this.sz == this.data.length) throw new IllegalArgumentException("Queue is Full!");
		int avail = (this.f + this.sz) % this.data.length;
		this.data[avail] = element;
		this.sz++;
	}
	
	public T dequeue() {
		if (isEmpty()) return null;
		T temp = this.data[this.f];
		this.data[f] = null;
		this.f = (this.f+1) % this.data.length;
		this.sz--;
		return temp;
	}
}
