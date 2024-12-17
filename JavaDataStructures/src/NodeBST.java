import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NodeBST<T extends Comparable<? super T>> {
	private TreeNode<T> root;
	private int size = 0;
	
	public NodeBST() {
		
	}
	
	public TreeNode<T> getRoot() {
		return this.root;
	}
	
	public void setRoot(TreeNode<T> root) {
		this.root = root;
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public int getHeight(TreeNode<T> node) {
		if (isEmpty()) return 0;
		if (node == null) return 0;
		int leftHeight = getHeight(node.getLeft());
		int rightHeight = getHeight(node.getRight());
		return 1 + Math.max(leftHeight, rightHeight);
	}
	
	public int getDepth(TreeNode<T> node) {
		if (node == null) return -1;
		else return 1 + getDepth(node.parent);
	}
	
	public void insert(T data) {
		if (contains(data)) return;
		this.root = insertRec(this.root, data);
	}
	
	public TreeNode<T> insertRec(TreeNode<T> node, T data) {
		if (node == null) {
			this.size++;
			return new TreeNode<T>(data);
		}
		else if (data.compareTo(node.getData()) <= 0) {
			node.setLeft(insertRec(node.getLeft(), data));
			node.getLeft().setParent(node);
		} else if (data.compareTo(node.getData()) > 0) {
			node.setRight(insertRec(node.getRight(), data));
			node.getRight().setParent(node);
		}
		return node;
	}
	
	public boolean remove(T data) {
		if (!contains(data)) return false;
		this.root = removeRec(this.root, data);
		this.size--;
		return true;
	}
	
	public TreeNode<T> removeRec(TreeNode<T> node, T data) {
		if (node == null) return null;
		else if (data.compareTo(node.getData()) < 0) {
			node.setLeft(removeRec(node.getLeft(), data));
			if (node.getLeft() != null) node.getLeft().setParent(node);
		} else if (data.compareTo(node.getData()) > 0) {
			node.setRight(removeRec(node.getRight(), data));
			if (node.getRight() != null) node.getRight().setParent(node);
		} else {
			if (node.getLeft() == null) return node.getRight();
			if (node.getRight() == null) return node.getLeft();
			node.setData(findMin(node.getRight()));
			node.setRight(removeRec(node.getRight(), node.getData()));
		}
		return node;
//		if (isEmpty()) return null;
//		if (data.compareTo(node.getData()) == 0) {
//			if (isExternal(node)) {
//				if (node != this.root) {
//					TreeNode<T> parent = node.getParent();
//					if (node == node.getParent().getLeft()) node.getParent().setLeft(null);
//					else node.getParent().setRight(null);
//					node.setParent(null);
//					return parent;
//				} else this.root = null;
//			} else {
//				T replace = null;
//				if (node.getRight() != null) {
//					replace = findMin(node.getRight());
//					removeRec(node.getRight(), replace);
//				} else {
//					replace = findMax(node.getLeft());
//					removeRec(node.getLeft(), replace);
//				}
//				node.setData(replace);
//			}
//		} else if (data.compareTo(node.getData()) < 0) removeRec(node.getLeft(), data);
//		else removeRec(node.getRight(), data);
//		return node;
	}
	
	public T findMin(TreeNode<T> node) {
		TreeNode<T> curr = node;
		while (curr.getLeft() != null) {
			curr = curr.getLeft();
		}
		return curr.getData();
	}
	
	public T findMax(TreeNode<T> node) {
		TreeNode<T> curr = node;
		while (curr.getRight() != null) {
			curr = curr.getRight();
		}
		return curr.getData();
	}
	
	public boolean isExternal(TreeNode<T> node) {
		if (node.getLeft() == null && node.getRight() == null) return true;
		return false;
	}
	
	public boolean contains(T data) {
		if (isEmpty()) return false;
		Queue<TreeNode<T>> q = new LinkedList<>();
		q.add(this.root);
		while (!q.isEmpty()) {
			TreeNode<T> curr = q.poll();
			if (data.compareTo(curr.getData()) == 0) return true;
			if (curr.getLeft() != null) q.add(curr.getLeft());
			if (curr.getRight() != null) q.add(curr.getRight());
		}
		return false;
	}
	
	public void levelorder() {
		if (isEmpty()) {
			System.out.println("null");
			return;
		}
		String res = "";
		Queue<TreeNode<T>> q = new LinkedList<>();
		q.add(this.root);
		while (!q.isEmpty()) {
			TreeNode<T> curr = q.poll();
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
		Stack<TreeNode<T>> s = new Stack<>();
		s.push(this.root);
		while (!s.isEmpty()) {
			TreeNode<T> curr = s.pop();
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
		Stack<TreeNode<T>> s1 = new Stack<>();
		Stack<TreeNode<T>> s2 = new Stack<>();
		s1.push(this.root);
		while (!s1.isEmpty()) {
			TreeNode<T> curr = s1.pop();
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
		Stack<TreeNode<T>> s = new Stack<>();
		TreeNode<T> curr = this.root;
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
	class TreeNode<T> {
		private T data;
		private TreeNode<T> left, right, parent;
		private int height = 0;
		
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
		
		public void setRight(TreeNode<T> right) {
			this.right = right;
		}
		
		public TreeNode<T> getParent() {
			return this.parent;
		}
		
		public void setParent(TreeNode<T> parent) {
			this.parent = parent;
		}
		
		public int getHeight() {
			return this.height;
		}
		
		public void setHeight(int height) {
			this.height = height;
		}
		
		public String toString() {
			return "[" + this.data.toString() + "]";
		}
	}
}
