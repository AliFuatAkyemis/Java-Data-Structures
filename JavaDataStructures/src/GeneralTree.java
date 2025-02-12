import java.util.ArrayList;
import java.util.List;

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
		if (this.root == null) this.root = new TreeNode<T>(data);
		else {
			
		}
	}
	
	public void remove(T data) {
		
	}
	
	public boolean contains(TreeNode<T> node, T data) {
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
