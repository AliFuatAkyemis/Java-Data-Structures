import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NodeHeap<K extends Comparable<? super K>, V> {
	private TreeNode<Entry<K, V>> root;
	private int size = 0;
	
	public NodeHeap() {
		
	}
	
	public TreeNode<Entry<K, V>> getRoot() {
		return this.root;
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	private void heapifyUp(TreeNode<Entry<K, V>> node) {
		if (node == null) return;
		else if (node.getParent() == null) return;
		if (node.getData().getKey().compareTo(node.getParent().getData().getKey()) >= 0) return;
		else {
			swap(node.getParent(), node);
			heapifyUp(node.getParent());
		}
	}
	
	private void heapifyDown(TreeNode<Entry<K, V>> node) {
		if (node.getLeft() == null && node.getRight() == null) return;
		if (node.getLeft() != null && node.getRight() != null) {
			if (node.getLeft().getData().getKey().compareTo(node.getRight().getData().getKey()) <= 0) {
				if (node.getData().getKey().compareTo(node.getLeft().getData().getKey()) > 0) {
					swap(node, node.getLeft());
					heapifyDown(node.getLeft());
				}
			} else {
				if (node.getData().getKey().compareTo(node.getRight().getData().getKey()) > 0) {
					swap(node, node.getRight());
					heapifyDown(node.getRight());
				}
			}
		} else if (node.getRight() == null) {
			if (node.getData().getKey().compareTo(node.getLeft().getData().getKey()) > 0) {
				swap(node, node.getLeft());
				heapifyDown(node.getLeft());
			}
		} else if (node.getLeft() == null) {
			if (node.getData().getKey().compareTo(node.getRight().getData().getKey()) > 0) {
				swap(node, node.getRight());
				heapifyDown(node.getRight());
			}
		} else return;
	}
	
	private void swap(TreeNode<Entry<K, V>> node1, TreeNode<Entry<K, V>> node2) {
		Entry<K, V> temp = node1.getData();
		node1.setData(node2.getData());
		node2.setData(temp);
	}
	
	public void insert(K key, V value) {
		if (isEmpty()) {
			this.root = new TreeNode<Entry<K, V>>(new Entry<K, V>(key, value));
			this.size++;
		}
		else {
			TreeNode<Entry<K, V>> avail = avail();
			if (avail.getLeft() == null) {
				avail.setLeft(new TreeNode<Entry<K, V>>(new Entry<K, V>(key, value)));
				avail.getLeft().setParent(avail);
				heapifyUp(avail.getLeft());
			}
			else {
				avail.setRight(new TreeNode<Entry<K, V>>(new Entry<K, V>(key, value)));
				avail.getRight().setParent(avail);
				heapifyUp(avail.getRight());
			}
			this.size++;
		}
	}
	
	public V peek() {
		if (isEmpty()) return null;
		return this.root.getData().getValue();
	}
	
	public V remove() {
		if (isEmpty()) return null;
		TreeNode<Entry<K, V>> replace = replace();
		if (replace.equals(this.root)) {
			this.root = null;
			this.size--;
			return replace.getData().getValue();
		}
		V res = this.root.getData().getValue();
		this.root.setData(replace.getData());
		heapifyDown(this.root);
		this.size--;
		return res;
	}
	
	public TreeNode<Entry<K, V>> avail() {
		if (isEmpty()) return null;
		Queue<TreeNode<Entry<K, V>>> q = new LinkedList<>();
		q.add(this.root);
		while (!q.isEmpty()) {
			TreeNode<Entry<K, V>> curr = q.poll();
			if (curr.getLeft() != null) q.add(curr.getLeft());
			else return curr;
			if (curr.getRight() != null) q.add(curr.getRight());
			else return curr;
		}
		return null;
	}
	
	public TreeNode<Entry<K, V>> replace() {
		if (isEmpty()) return null;
		Queue<TreeNode<Entry<K, V>>> q = new LinkedList<>();
		q.add(this.root);TreeNode<Entry<K, V>> curr = null;
		while (!q.isEmpty()) {
			curr = q.poll();
			if (curr.getLeft() != null) q.add(curr.getLeft());
			if (curr.getRight() != null) q.add(curr.getRight());
		}
		if (curr.equals(this.root)) return curr;
		if (curr.getParent().getLeft().equals(curr)) {
			curr.getParent().setLeft(null);
			curr.setParent(null);
		} else {
			curr.getParent().setRight(null);
			curr.setParent(null);
		}
		return curr;
	}
	
	public void levelorder() {
		if (isEmpty()) {
			System.out.println("null");
			return;
		}
		String res = "";
		Queue<TreeNode<Entry<K, V>>> q = new LinkedList<>();
		q.add(this.root);
		while (!q.isEmpty()) {
			TreeNode<Entry<K, V>> curr = q.poll();
			res += curr.toString() + ", ";
			if (curr.getLeft() != null) q.add(curr.getLeft());
			if (curr.getRight() != null) q.add(curr.getRight());
		}
		System.out.println(res.substring(0, res.length()-2));
	}
	
	public void preorder() {
		if (isEmpty()) {
			System.out.println("null");
			return;
		}
		String res = "";
		Stack<TreeNode<Entry<K, V>>> s = new Stack<>();
		s.push(this.root);
		while (!s.isEmpty()) {
			TreeNode<Entry<K, V>> curr = s.pop();
			res += curr.toString() + ", ";
			if (curr.getRight() != null) s.push(curr.getRight());
			if (curr.getLeft() != null) s.push(curr.getLeft());
		}
		System.out.println(res.substring(0, res.length()-2));
	}
	
	public void postorder() {
		if (isEmpty()) {
			System.out.println("null");
			return;
		}
		String res = "";
		Stack<TreeNode<Entry<K, V>>> s1 = new Stack<>();
		Stack<TreeNode<Entry<K, V>>> s2 = new Stack<>();
		s1.push(this.root);
		while (!s1.isEmpty()) {
			TreeNode<Entry<K, V>> curr = s1.pop();
			s2.push(curr);
			if (curr.getLeft() != null) s1.push(curr.getLeft());
			if (curr.getRight() != null) s1.push(curr.getRight());
		}
		while (!s2.isEmpty()) res += s2.pop().toString() + ", ";
		System.out.println(res.substring(0, res.length()-2));
	}
	
	public void inorder() {
		if (isEmpty()) {
			System.out.println("null");
			return;
		}
		String res = "";
		Stack<TreeNode<Entry<K, V>>> s = new Stack<>();
		TreeNode<Entry<K, V>> curr = this.root;
		while (curr != null || !s.isEmpty()) {
			while (curr != null) {
				s.push(curr);
				curr = curr.getLeft();
			}
			curr = s.pop();
			res += curr.toString() + ", ";
			curr = curr.getRight();
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
			return this.key.toString() + ", " + this.value.toString();
		}
	}
	
	class TreeNode<T> {
		private T data;
		private TreeNode<T> left, right, parent;
		
		public TreeNode(T data) {
			this.data = data;
		}
		
		public T getData() {
			return this.data;
		}
		
		public void setData(T data) {
			this.data = data;
		}
		
		public TreeNode<T> getLeft() {
			return this.left;
		}
		
		public void setLeft(TreeNode<T> left) {
			this.left = left;
		}
		
		public TreeNode<T> getRight() {
			return this.right;
		}
		
		public TreeNode<T> getParent() {
			return this.parent;
		}
		
		public void setParent(TreeNode<T> parent) {
			this.parent = parent;
		}
		
		public void setRight(TreeNode<T> right) {
			this.right = right;
		}
		
		public String toString() {
			return "[" + this.data.toString() + "]";
		}
	}
}