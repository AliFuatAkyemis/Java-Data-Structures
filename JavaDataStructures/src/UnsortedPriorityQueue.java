
public class UnsortedPriorityQueue<K extends Comparable<? super K>, V> extends AbstractPriorityQueue<K, V> {
	private Node<Entry<K, V>> head;
	private int size = 0;
	
	public UnsortedPriorityQueue() {
		
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public String toString() {
		if (isEmpty()) return null;
		String res = "";
		Node<Entry<K, V>> temp = this.head;
		while (temp != null) {
			res += temp.toString() + " > ";
			temp = temp.getNext();
		}
		return res.substring(0, res.length()-3);
	}
	
	public V peek() {
		if (isEmpty()) return null;
		Node<Entry<K, V>> temp = this.head;
		Entry<K, V> min = temp.getData();
		while (temp != null) {
			if (temp.getData().getKey().compareTo(min.getKey()) < 0) min = temp.getData();
			temp = temp.getNext();
		}
		return min.getValue();
	}
	
	public V remove() {
		if (isEmpty()) return null;
		Node<Entry<K, V>> temp = this.head, min = temp;
		while (temp != null) {
			if (min.getData().getKey().compareTo(temp.getData().getKey()) > 0) min = temp;
			temp = temp.getNext();
		}
		if (this.head == min) {
			this.head = this.head.getNext();
			min.setNext(null);
			this.size--;
			return min.getData().getValue();
		} else {
			temp = this.head;
			while (temp.getNext() != min) temp = temp.getNext();
			temp.setNext(min.getNext());
			min.setNext(null);
			this.size--;
			return min.getData().getValue();
		}
	}
	
	public void insert(K key, V value) {
		this.head = new Node<Entry<K, V>>(new Entry<K, V>(key, value), this.head);
		this.size++;
	}
}