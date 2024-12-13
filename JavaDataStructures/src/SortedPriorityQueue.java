
public class SortedPriorityQueue<K extends Comparable<? super K>, V> extends AbstractPriorityQueue<K, V> {
	private Node<Entry<K, V>> head;
	private int size = 0;
	
	public SortedPriorityQueue() {
		
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
		return this.head.getData().getValue();
	}
	
	public V remove() {
		if (isEmpty()) return null;
		Node<Entry<K, V>> res = this.head;
		this.head = this.head.getNext();
		res.setNext(null);
		this.size--;
		return res.getData().getValue();
	}
	
	public void insert(K key, V value) {
		if (isEmpty() || key.compareTo(this.head.getData().getKey()) < 0) {
			this.head = new Node<Entry<K, V>>(new Entry<K, V>(key, value), this.head);
			this.size++;
			return;
		}
		Node<Entry<K, V>> temp = this.head;
		while (temp.getNext() != null && key.compareTo(temp.getNext().getData().getKey()) > 0) temp = temp.getNext();
		temp.setNext(new Node<Entry<K, V>>(new Entry<K, V>(key, value), temp.getNext()));
		this.size++;
	}
}