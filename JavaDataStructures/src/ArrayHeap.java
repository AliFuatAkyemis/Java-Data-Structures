import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ArrayHeap<K extends Comparable<? super K>, V> {
	private static final int CAPACITY = 1000;
	private Entry<K, V>[] array;
	private int size = 0;
	
	public ArrayHeap() {
		this(CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayHeap(int capacity) {
		this.array = (Entry<K, V>[]) new Entry[capacity];
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	private void heapifyUp(int index) {
		if (index <= 0) return;
		else if (index%2 == 1 && this.array[index].getKey().compareTo(this.array[leftParent(index)].getKey()) < 0) {
			swap(index, leftParent(index));
			heapifyUp(leftParent(index));
		} else if (index%2 == 0 && this.array[index].getKey().compareTo(this.array[rightParent(index)].getKey()) < 0) {
			swap(index, rightParent(index));
			heapifyUp(rightParent(index));
		}
	}
	
	private void heapifyDown(int index) {
		if (isEmpty()) return;
		if (this.array[left(index)] == null && this.array[right(index)] == null) return;
		if (this.array[left(index)] != null && this.array[right(index)] != null) {
			if (this.array[left(index)].getKey().compareTo(this.array[right(index)].getKey()) <= 0) {
				if (this.array[index].getKey().compareTo(this.array[left(index)].getKey()) > 0) {
					swap(index, left(index));
					heapifyDown(left(index));
				}
			} else {
				if (this.array[index].getKey().compareTo(this.array[right(index)].getKey()) > 0) {
					swap(index, right(index));
					heapifyDown(right(index));
				}
			}
		} else if (this.array[right(index)] == null) {
			if (this.array[index].getKey().compareTo(this.array[left(index)].getKey()) > 0) {
				swap(index, left(index));
				heapifyDown(left(index));
			}
		} else if (this.array[left(index)] == null) {
			if (this.array[index].getKey().compareTo(this.array[right(index)].getKey()) > 0) {
				swap(index, right(index));
				heapifyDown(right(index));
			}
		} else return;
	}
	
	private void swap(int index, int otherIndex) {
		Entry<K, V> temp = this.array[index];
		this.array[index] = this.array[otherIndex];
		this.array[otherIndex] = temp;
	}
	
	public void insert(K key, V value) {
		if (isEmpty()) {
			this.array[0] = new Entry<K, V>(key, value);
			this.size++;
			return;
		}
		int avail = avail();
		this.array[avail] = new Entry<K, V>(key, value);
		heapifyUp(avail);
		this.size++;
	}
	
	public V peek() {
		if (isEmpty()) return null;
		return this.array[0].getValue();
	}
	
	public V remove() {
		if (isEmpty()) return null;
		int replace = replace();
		if (replace == 0) {
			V res = this.array[0].getValue();
			this.array[0] = null;
			this.size--;
			return res;
		}
		V res = this.array[0].getValue();
		this.array[0] = this.array[replace];
		this.array[replace] = null;
		heapifyDown(0);
		this.size--;
		return res;
	}
	
	public int avail() {
		if (isEmpty()) return 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		while (!q.isEmpty()) {
			int curr = q.poll();
			if (this.array[left(curr)] != null) q.add(left(curr));
			else return left(curr);
			if (this.array[right(curr)] != null) q.add(right(curr));
			else return right(curr);
		}
		return 0;
	}
	
	public int replace() {
		if (isEmpty()) return 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		int curr = 0;
		while (!q.isEmpty()) {
			curr = q.poll();
			if (this.array[left(curr)] != null) q.add(left(curr));
			if (this.array[right(curr)] != null) q.add(right(curr));
		}
		return curr;
	}
	
	public int left(int index) {
		return 2*index+1;
	}
	
	public int right(int index) {
		return 2*index+2;
	}
	
	public int leftParent(int index) {
		return (index-1)/2;
	}
	
	public int rightParent(int index) {
		return (index-2)/2;
	}
	
	public void levelorder() {
		if (isEmpty()) {
			System.out.println("null");
			return;
		}
		String res = "";
		for (int i = 0;i < this.array.length;i++) {
			if (this.array[i] != null) res += this.array[i].toString() + ", ";
		}
		System.out.println(res.substring(0, res.length()-2));
	}
	
	public void preorder() {
		if (isEmpty()) {
			System.out.println("null");
			return;
		}
		String res = "";
		Stack<Integer> s = new Stack<>();
		s.push(0);
		while (!s.isEmpty()) {
			int curr = s.pop();
			res += this.array[curr].toString() + ", ";
			if (this.array[right(curr)] != null) s.push(right(curr));
			if (this.array[left(curr)] != null) s.push(left(curr));
		}
		System.out.println(res.substring(0, res.length()-2));
	}
	
	public void postorder() {
		if (isEmpty()) {
			System.out.println("null");
			return;
		}
		String res = "";
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		s1.push(0);
		while (!s1.isEmpty()) {
			int curr = s1.pop();
			s2.push(curr);
			if (this.array[left(curr)] != null) s1.push(left(curr));
			if (this.array[right(curr)] != null) s1.push(right(curr));
		}
		while (!s2.isEmpty()) res += this.array[s2.pop()].toString() + ", ";
		System.out.println(res.substring(0, res.length()-2));
	}
	
	public void inorder() {
		if (isEmpty()) {
			System.out.println("null");
			return;
		}
		String res = "";
		Stack<Integer> s = new Stack<>();
		int curr = 0;
		while (this.array[curr] != null || !s.isEmpty()) {
			while (this.array[curr] != null) {
				s.push(curr);
				curr = left(curr);
			}
			curr = s.pop();
			res += this.array[curr].toString() + ", ";
			curr = right(curr);
		}
		System.out.println(res.substring(0, res.length()-2));
	}
	
	@SuppressWarnings("hiding")
	class Entry<K extends Comparable<? super K>, V> {
		private K key;
		private V value;
		
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		public K getKey() {
			return this.key;
		}
		
		public V getValue() {
			return this.value;
		}
		
		public String toString() {
			return "[" + this.key.toString() + ", " + this.value.toString() + "]";
		}
	}
}
