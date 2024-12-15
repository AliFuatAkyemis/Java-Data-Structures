import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ArrayBST<T extends Comparable<? super T>> {
	private static final int CAPACITY = 1000;
	private T[] array;
	private int size = 0;
	
	public ArrayBST() {
		this(CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayBST(int capacity) {
		this.array = (T[]) new Comparable[capacity];
	}
	
	public T getRoot() {
		return this.array[0];
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public int getHeight(int index) {
		if (isEmpty()) return 0;
		if (index < 0) return 0;
		if (this.array[index] == null) return 0;
		int leftHeight = getHeight(left(index));
		int rightHeight = getHeight(right(index));
		return 1 + Math.max(leftHeight, rightHeight);
	}
	
	public int getDepth(int index) {
		if (index <= 0) return 0;
		else if (index%2 == 1) return 1 + getDepth(leftParent(index));
		else return 1 + getDepth(rightParent(index));
	}
	
	public void insert(T data) {
		if (contains(data)) return;
		insertRec(0, data);
	}
	
	public void insertRec(int index, T data) {
		if (this.array[index] == null) {
			this.size++;
			this.array[index] = data;
			return;
		}
		else if (data.compareTo(this.array[index]) <= 0) insertRec(left(index), data);
		else if (data.compareTo(this.array[index]) > 0) insertRec(right(index), data);
	}
	
	public boolean remove(T data) {
		if (!contains(data)) return false;
		removeRec(0, data);
		this.size--;
		return true;
	}
	
	public void removeRec(int index, T data) {
		if (data.compareTo(this.array[index]) == 0) {
			if (isExternal(index)) {
				this.array[index] = null;
			} else {
				T rep = null;
				if (this.array[right(index)] != null) {
					rep = findMin(right(index));
					removeRec(right(index), rep);
				}
				else {
					rep = findMax(left(index));
					removeRec(left(index), rep);
				}
				this.array[index] = rep;
			}
		} else if (data.compareTo(this.array[index]) < 0) removeRec(left(index), data);
		else removeRec(right(index), data);
	}
	
	public T findMin(int index) {
		while (this.array[left(index)] != null) index = left(index);
		return this.array[index];
	}
	
	public T findMax(int index) {
		while (this.array[right(index)] != null) index = right(index);
		return this.array[index];
	}
	
	public boolean isExternal(int index) {
		if (this.array[left(index)] == null && this.array[right(index)] == null) return true;
		return false;
	}
	
	public boolean contains(T data) {
		if (isEmpty()) return false;
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		while (!q.isEmpty()) {
			int curr = q.poll();
			if (this.array[curr].compareTo(data) == 0) return true;
			if (this.array[left(curr)] != null) q.add(left(curr));
			if (this.array[right(curr)] != null) q.add(right(curr));
		}
		return false;
	}
	
	public void levelorder() {
		if (isEmpty()) {
			System.out.println("null");
			return;
		}
		String res = "";
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		while (!q.isEmpty()) {
			int curr = q.poll();
			res += "[" + this.array[curr].toString() + "]" + ", ";
			if (this.array[left(curr)] != null) q.add(left(curr));
			if (this.array[right(curr)] != null) q.add(right(curr));
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
			res += "[" + this.array[curr].toString() + "]" + ", ";
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
		while (!s2.isEmpty()) res += "[" + this.array[s2.pop()].toString() + "]" + ", ";
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
			res += "[" + this.array[curr].toString() + "]" + ", ";
			curr = right(curr);
		}
		System.out.println(res.substring(0, res.length()-2));
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
}
