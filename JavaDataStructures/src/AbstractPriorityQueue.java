
public abstract class AbstractPriorityQueue<K extends Comparable<? super K>, V> {
	private Node<Entry<K, V>> head;
	
	@SuppressWarnings("unused")
	private Node<Entry<K, V>> getHead() {
		return this.head;
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
			return value.toString();
		}
	}
	
	class Node<T> {
		private T data;
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
		
		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
		
		public T getData() {
			return this.data;
		}
		
		public Node<T> getNext() {
			return this.next;
		}
		
		public void setNext(Node<T> next) {
			this.next = next;
		}
		
		public String toString() {
			return "[" + this.data.toString() + "]";
		}
	}
}