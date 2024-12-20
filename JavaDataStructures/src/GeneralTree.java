import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GeneralTree<T> {
	private TreeNode<T> root;
	private int size = 0;
	
	public GeneralTree() {
		
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public int getHeight(TreeNode<T> node) {
		return 0;
	}
	
	public int getDepth(TreeNode<T> node) {
		return 0;
	}
	
	public void insert(T data) {
		
	}
	
	public void remove(T data) {
		
	}
	
	public boolean contains(T data) {
		if (isEmpty()) return false;
		Queue<TreeNode<T>> q = new LinkedList<>();
		q.add(this.root);
		while (!q.isEmpty()) {
			TreeNode<T> curr = q.poll();
			if (curr.getData() == data) return true;
			
		}
		return false;
	}
	
	public void levelorder() {
		
	}
	
	public void preorder() {
		
	}
	
	public void postorder() {
		
	}
	
	public void inorder() {
		
	}
	
	@SuppressWarnings("hiding")
	class TreeNode<T> {
		private T data;
		private TreeNode<T> parent;
		private List<TreeNode<T>> children;
		
		public TreeNode(T data) {
			this.data = data;
			this.children = new ArrayList<>();
		}
		
		public T getData() {
			return this.data;
		}
		
		public void setData(T data) {
			this.data = data;
		}
		
		public TreeNode<T> getParent() {
			return this.parent;
		}
		
		public void setParent(TreeNode<T> parent) {
			this.parent = parent;
		}
		
		public List<TreeNode<T>> getChildren() {
			return this.children;
		}
		
		public void addChildren(T data) {
			this.children.add(new TreeNode<T>(data));
		}
	}
}
