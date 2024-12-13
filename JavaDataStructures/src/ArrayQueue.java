
public class ArrayQueue<T> {
	private static final int CAPACITY = 1000;
	private T[] array;
	private int f = 0;
	private int sz = 0;
	
	public ArrayQueue() {
		this(CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(int capacity) {
		this.array = (T[]) new Object[capacity];
	}
	
	public int size() {
		return this.sz;
	}
	
	public boolean isEmpty() {
		return this.sz == 0;
	}
	
	public String toString() {
		if (isEmpty()) return null;
		String res = "";
		for (int i = 0;i < this.sz;i++) {
			res += "[" + this.array[(this.f+i)%this.array.length] + "]" + " > ";
		}
		return res.substring(0, res.length()-3);
	}
	
	public T first() {
		if (isEmpty()) return null;
		return this.array[this.f];
	}
	
	public T dequeue() {
		if (isEmpty()) return null;
		T res = this.array[this.f];
		this.array[this.f] = null;
		this.f = (this.f+1)%this.array.length;
		this.sz--;
		return res;
	}
	
	public void enqueue(T data) throws IllegalArgumentException {
		if (this.sz == this.array.length) throw new IllegalArgumentException("Queue is Full!");
		int avail = ((this.f+this.sz)%this.array.length);
		this.array[avail] = data;
		this.sz++;
	}
}
