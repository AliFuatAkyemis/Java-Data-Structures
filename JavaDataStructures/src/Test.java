
public class Test {
	public static void main(String[] args) {
//		testSLL();
//		testDLL();
//		testCLL();
//		testLS();
//		testAS();
//		testLQ();
//		testAQ();
	}
	
	public static void testSLL() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.addFirst(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addLast(5);
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeFirst());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeFirst());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeFirst());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeFirst());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeFirst());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeFirst());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeFirst());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		list.addFirst(5);
		list.addFirst(4);
		list.addFirst(3);
		list.addFirst(2);
		list.addFirst(1);
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeFirst());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeFirst());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeFirst());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeFirst());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeFirst());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeFirst());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeFirst());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addLast(5);
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
	}
	
	public static void testDLL() {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.addFirst(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addLast(5);
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeFirst());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeFirst());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeFirst());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeFirst());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeFirst());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeFirst());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeFirst());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		list.addFirst(5);
		list.addFirst(4);
		list.addFirst(3);
		list.addFirst(2);
		list.addFirst(1);
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeLast());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeLast());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeLast());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeLast());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeLast());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeLast());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeLast());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addLast(5);
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
	}
	
	public static void testCLL() {
		CircularLinkedList<Integer> list = new CircularLinkedList<>();
		list.addFirst(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addLast(5);
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeFirst());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeFirst());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeFirst());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeFirst());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeFirst());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeFirst());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeFirst());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		list.addFirst(5);
		list.addFirst(4);
		list.addFirst(3);
		list.addFirst(2);
		list.addFirst(1);
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeFirst());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeFirst());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeFirst());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeFirst());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeFirst());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeFirst());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		System.out.println("Removed: " + list.removeFirst());
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addLast(5);
		System.out.println("Size: " + list.size());
		System.out.println(list.toString());
	}
	
	public static void testLS() {
		LinkedStack<Integer> s = new LinkedStack<>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		System.out.println("Size: " + s.size());
		System.out.println(s.toString());
		System.out.println("Popped: " + s.pop());
		System.out.println("Size: " + s.size());
		System.out.println(s.toString());
		System.out.println("Popped: " + s.pop());
		System.out.println("Size: " + s.size());
		System.out.println(s.toString());
		System.out.println("Popped: " + s.pop());
		System.out.println("Size: " + s.size());
		System.out.println(s.toString());
		System.out.println("Popped: " + s.pop());
		System.out.println("Size: " + s.size());
		System.out.println(s.toString());
		System.out.println("Popped: " + s.pop());
		System.out.println("Size: " + s.size());
		System.out.println(s.toString());
		System.out.println("Popped: " + s.pop());
		System.out.println("Size: " + s.size());
		System.out.println(s.toString());
		System.out.println("Popped: " + s.pop());
		System.out.println("Size: " + s.size());
		System.out.println(s.toString());
		s.push(5);
		s.push(4);
		s.push(3);
		s.push(2);
		s.push(1);
		System.out.println("Size: " + s.size());
		System.out.println(s.toString());
		System.out.println("Popped: " + s.pop());
		System.out.println("Size: " + s.size());
		System.out.println(s.toString());
		System.out.println("Popped: " + s.pop());
		System.out.println("Size: " + s.size());
		System.out.println(s.toString());
		System.out.println("Popped: " + s.pop());
		System.out.println("Size: " + s.size());
		System.out.println(s.toString());
		System.out.println("Popped: " + s.pop());
		System.out.println("Size: " + s.size());
		System.out.println(s.toString());
		System.out.println("Popped: " + s.pop());
		System.out.println("Size: " + s.size());
		System.out.println(s.toString());
		System.out.println("Popped: " + s.pop());
		System.out.println("Size: " + s.size());
		System.out.println(s.toString());
		System.out.println("Popped: " + s.pop());
		System.out.println("Size: " + s.size());
		System.out.println(s.toString());
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		System.out.println("Size: " + s.size());
		System.out.println(s.toString());
	}
	
	public static void testAS() {
		ArrayStack<Integer> s = new ArrayStack<>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		System.out.println("Size: " + s.size());
		System.out.println(s.toString());
		System.out.println("Popped: " + s.pop());
		System.out.println("Size: " + s.size());
		System.out.println(s.toString());
		System.out.println("Popped: " + s.pop());
		System.out.println("Size: " + s.size());
		System.out.println(s.toString());
		System.out.println("Popped: " + s.pop());
		System.out.println("Size: " + s.size());
		System.out.println(s.toString());
		System.out.println("Popped: " + s.pop());
		System.out.println("Size: " + s.size());
		System.out.println(s.toString());
		System.out.println("Popped: " + s.pop());
		System.out.println("Size: " + s.size());
		System.out.println(s.toString());
		System.out.println("Popped: " + s.pop());
		System.out.println("Size: " + s.size());
		System.out.println(s.toString());
		System.out.println("Popped: " + s.pop());
		System.out.println("Size: " + s.size());
		System.out.println(s.toString());
		s.push(5);
		s.push(4);
		s.push(3);
		s.push(2);
		s.push(1);
		System.out.println("Size: " + s.size());
		System.out.println(s.toString());
		System.out.println("Popped: " + s.pop());
		System.out.println("Size: " + s.size());
		System.out.println(s.toString());
		System.out.println("Popped: " + s.pop());
		System.out.println("Size: " + s.size());
		System.out.println(s.toString());
		System.out.println("Popped: " + s.pop());
		System.out.println("Size: " + s.size());
		System.out.println(s.toString());
		System.out.println("Popped: " + s.pop());
		System.out.println("Size: " + s.size());
		System.out.println(s.toString());
		System.out.println("Popped: " + s.pop());
		System.out.println("Size: " + s.size());
		System.out.println(s.toString());
		System.out.println("Popped: " + s.pop());
		System.out.println("Size: " + s.size());
		System.out.println(s.toString());
		System.out.println("Popped: " + s.pop());
		System.out.println("Size: " + s.size());
		System.out.println(s.toString());
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		System.out.println("Size: " + s.size());
		System.out.println(s.toString());
	}
	
	public static void testLQ() {
		LinkedQueue<Integer> q = new LinkedQueue<>();
		q.enqueue(5);
		q.enqueue(4);
		q.enqueue(3);
		q.enqueue(2);
		q.enqueue(1);
		System.out.println("Size: " + q.size());
		System.out.println(q.toString());
		System.out.println("Dequeued: " + q.dequeue());
		System.out.println("Size: " + q.size());
		System.out.println(q.toString());
		System.out.println("Dequeued: " + q.dequeue());
		System.out.println("Size: " + q.size());
		System.out.println(q.toString());
		System.out.println("Dequeued: " + q.dequeue());
		System.out.println("Size: " + q.size());
		System.out.println(q.toString());
		System.out.println("Dequeued: " + q.dequeue());
		System.out.println("Size: " + q.size());
		System.out.println(q.toString());
		System.out.println("Dequeued: " + q.dequeue());
		System.out.println("Size: " + q.size());
		System.out.println(q.toString());
		System.out.println("Dequeued: " + q.dequeue());
		System.out.println("Size: " + q.size());
		System.out.println(q.toString());
		System.out.println("Dequeued: " + q.dequeue());
		System.out.println("Size: " + q.size());
		System.out.println(q.toString());
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		System.out.println("Size: " + q.size());
		System.out.println(q.toString());
		System.out.println("Dequeued: " + q.dequeue());
		System.out.println("Size: " + q.size());
		System.out.println(q.toString());
		System.out.println("Dequeued: " + q.dequeue());
		System.out.println("Size: " + q.size());
		System.out.println(q.toString());
		System.out.println("Dequeued: " + q.dequeue());
		System.out.println("Size: " + q.size());
		System.out.println(q.toString());
		System.out.println("Dequeued: " + q.dequeue());
		System.out.println("Size: " + q.size());
		System.out.println(q.toString());
		System.out.println("Dequeued: " + q.dequeue());
		System.out.println("Size: " + q.size());
		System.out.println(q.toString());
		System.out.println("Dequeued: " + q.dequeue());
		System.out.println("Size: " + q.size());
		System.out.println(q.toString());
		System.out.println("Dequeued: " + q.dequeue());
		System.out.println("Size: " + q.size());
		System.out.println(q.toString());
		q.enqueue(5);
		q.enqueue(4);
		q.enqueue(3);
		q.enqueue(2);
		q.enqueue(1);
		System.out.println("Size: " + q.size());
		System.out.println(q.toString());
	}
	
	public static void testAQ() {
		ArrayQueue<Integer> q = new ArrayQueue<>();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		System.out.println("Size: " + q.size());
		System.out.println(q.toString());
		System.out.println("Dequeued: " + q.dequeue());
		System.out.println("Size: " + q.size());
		System.out.println(q.toString());
		System.out.println("Dequeued: " + q.dequeue());
		System.out.println("Size: " + q.size());
		System.out.println(q.toString());
		System.out.println("Dequeued: " + q.dequeue());
		System.out.println("Size: " + q.size());
		System.out.println(q.toString());
		System.out.println("Dequeued: " + q.dequeue());
		System.out.println("Size: " + q.size());
		System.out.println(q.toString());
		System.out.println("Dequeued: " + q.dequeue());
		System.out.println("Size: " + q.size());
		System.out.println(q.toString());
		System.out.println("Dequeued: " + q.dequeue());
		System.out.println("Size: " + q.size());
		System.out.println(q.toString());
		System.out.println("Dequeued: " + q.dequeue());
		System.out.println("Size: " + q.size());
		System.out.println(q.toString());
		q.enqueue(5);
		q.enqueue(4);
		q.enqueue(3);
		q.enqueue(2);
		q.enqueue(1);
		System.out.println("Size: " + q.size());
		System.out.println(q.toString());
		System.out.println("Dequeued: " + q.dequeue());
		System.out.println("Size: " + q.size());
		System.out.println(q.toString());
		System.out.println("Dequeued: " + q.dequeue());
		System.out.println("Size: " + q.size());
		System.out.println(q.toString());
		System.out.println("Dequeued: " + q.dequeue());
		System.out.println("Size: " + q.size());
		System.out.println(q.toString());
		System.out.println("Dequeued: " + q.dequeue());
		System.out.println("Size: " + q.size());
		System.out.println(q.toString());
		System.out.println("Dequeued: " + q.dequeue());
		System.out.println("Size: " + q.size());
		System.out.println(q.toString());
		System.out.println("Dequeued: " + q.dequeue());
		System.out.println("Size: " + q.size());
		System.out.println(q.toString());
		System.out.println("Dequeued: " + q.dequeue());
		System.out.println("Size: " + q.size());
		System.out.println(q.toString());
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		System.out.println("Size: " + q.size());
		System.out.println(q.toString());
	}
}