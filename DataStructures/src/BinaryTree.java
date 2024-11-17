
public class BinaryTree<T> implements IBinaryTree<T> {
	private BinaryNode<T> root;
	private int size = 0;
	
	public BinaryTree() {
		
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		if (this.size == 0) return true;
		return false;
	}
	
	public String toString() {
		return null;
	}
	
	public BinaryNode<T> root() {
		return this.root;
	}
	
	public void setRoot(BinaryNode<T> root) {
		this.root = root;
	}
	
	public int getDepth(BinaryNode<T> node) {
		return 0;
	}
	
	public int getHeight(BinaryNode<T> node) {
		if (node == null) return 0;
		int leftHeight = getHeight(node.getLeft());
		int rightHeight = getHeight(node.getRight());
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	public void preorder(BinaryNode<T> node) {
		if (node == null) return;
		System.out.print(node.toString() + " > ");
		preorder(node.getLeft());
		preorder(node.getRight());
	}
	
	public void postorder(BinaryNode<T> node) {
		if (node == null) return;
		postorder(node.getLeft());
		postorder(node.getRight());
		System.out.print(node.toString() + " > ");
	}
	
	public void inorder(BinaryNode<T> node) {
		if (node == null) return;
		inorder(node.getLeft());
		System.out.print(node.toString() + " > ");
		inorder(node.getRight());
	}
	
	public void bfsTraversal(BinaryNode<T> node) {
		if (node == null) return;
		LinkedQueue<BinaryNode<T>> queue = new LinkedQueue<>();
		queue.enqueue(node);
		while (!queue.isEmpty()) {
			BinaryNode<T> currentNode = queue.dequeue();
			System.out.print(currentNode.toString() + " > ");
			if (currentNode.getLeft() != null) queue.enqueue(currentNode.getLeft());
			if (currentNode.getRight() != null) queue.enqueue(currentNode.getRight());
		}
	}
	
	public boolean bfs(BinaryNode<T> node, T data) {
		if (node == null) return false;
		LinkedQueue<BinaryNode<T>> queue = new LinkedQueue<>();
		queue.enqueue(node);
		while (!queue.isEmpty()) {
			BinaryNode<T> currentNode = queue.dequeue();
			if (currentNode.getData() == data) return true;
			if (currentNode.getLeft() != null) queue.enqueue(currentNode.getLeft());
			if (currentNode.getRight() != null) queue.enqueue(currentNode.getRight());
		}
		return false;
	}
	
	public void dfsTraversal(BinaryNode<T> node) {
		if (node == null) return;
		LinkedStack<BinaryNode<T>> stack = new LinkedStack<>();
		stack.push(node);
		while (!stack.isEmpty()) {
			BinaryNode<T> currentNode = stack.pop();
			System.out.print(currentNode.toString() + " > ");
			if (currentNode.getRight() != null) stack.push(currentNode.getRight());
			if (currentNode.getLeft() != null) stack.push(currentNode.getLeft());
		}
	}
	
	public boolean dfs(BinaryNode<T> node, T data) {
		if (node == null) return false;
		LinkedStack<BinaryNode<T>> stack = new LinkedStack<>();
		stack.push(node);
		while (!stack.isEmpty()) {
			BinaryNode<T> currentNode = stack.pop();
			if (currentNode.getData() == data) return true;
			if (currentNode.getRight() != null) stack.push(currentNode.getRight());
			if (currentNode.getLeft() != null) stack.push(currentNode.getLeft());
		}
		return false;
	}
}


