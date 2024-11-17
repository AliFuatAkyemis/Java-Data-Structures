
public interface Interfaces {

}

interface IPosition<T> {
	Position<T> getParent();
	Position<T> getChildren();
	void setParent(Position<T> parent);
	void setChildren(Position<T> children);
	T getData();
}

interface ITree<T> extends Iterable<T> {
	int size();
	boolean isEmpty();
	Iterable<T> positions();
	String toString();
	Position<T> root();
	Position<T> parent(Position<T> position) throws IllegalArgumentException;
	Iterable<Position<T>> children(Position<T> position) throws IllegalArgumentException;
	int numChildren(Position<T> position) throws IllegalArgumentException;
	boolean isInternal(Position<T> position) throws IllegalArgumentException;
	boolean isExternal(Position<T> position) throws IllegalArgumentException;
	boolean isRoot(Position<T> position) throws IllegalArgumentException;
}

interface IBinaryNode<T> {
	T getData();
	BinaryNode<T> getLeft();
	BinaryNode<T> getRight();
	void setData(T data);
	void setLeft(BinaryNode<T> prev);
	void setRight(BinaryNode<T> next);
	String toString();
}

interface IBinaryTree<T> {
	int size();
	boolean isEmpty();
	String toString();
	BinaryNode<T> root();
	int getDepth(BinaryNode<T> node);
	int getHeight(BinaryNode<T> node);
	void preorder(BinaryNode<T> node);
	void postorder(BinaryNode<T> node);
	void inorder(BinaryNode<T> node);
	void bfsTraversal(BinaryNode<T> node);
	void dfsTraversal(BinaryNode<T> node);
	boolean bfs(BinaryNode<T> node, T data);
	boolean dfs(BinaryNode<T> node, T data);
}

interface IList<T> {
	int size();
	boolean isEmpty();
	String toString();
}

interface IStaticList<T> extends IList<T> {
	T get(int i) throws IndexOutOfBoundsException;
	T set(int i, T e) throws IndexOutOfBoundsException;
	void add(int i, T e) throws IndexOutOfBoundsException, IllegalStateException;
	T remove(int i)  throws IndexOutOfBoundsException;
}

interface INode<T> {
	T getData();
	Node<T> getPrev();
	Node<T> getNext();
	void setData(T data);
	void setPrev(Node<T> prev);
	void setNext(Node<T> next);
	String toString();
}

interface ILinkedList<T> extends IList<T> {
	T first();
	T last();
	void addFirst(T e);
	void addLast(T e);
	T removeFirst();
}

interface ISingly<T> extends ILinkedList<T> {
	T removeLast();
}

interface ICircular<T> extends ILinkedList<T> {
	void rotate();
}

interface IDoubly<T> extends ILinkedList<T> {
	T removeLast();
//	void addBetween(E e, Node<T> prev, Node<T> next);
}

interface IStack<T> extends IList<T> {
	void push(T e);
	T pop();
	T top();
}

interface IQueue<T> extends IList<T> {
	void enqueue(T e);
	T dequeue();
	T first();
}