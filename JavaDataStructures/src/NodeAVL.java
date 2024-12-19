
public class NodeAVL<T extends Comparable<? super T>> extends NodeBST<T> {
	@Override
	public NodeBST<T>.TreeNode<T> insertRec(NodeBST<T>.TreeNode<T> node, T data) {
		node = super.insertRec(node, data);
		updateHeight(node);
		return rebalanceInsert(node);
	}

	@Override
	public boolean remove(T data) {
		boolean res = super.remove(data);
		rebalanceRemove(delPos(this.getRoot(), null, data));
		return res;
	}

	private int height(TreeNode<T> node) {
		return node == null ? 0 : node.getHeight();
	}

	private void updateHeight(TreeNode<T> node) {
		if (node != null) {
			node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));
		}
	}
	
	private int getBalanceFactor(TreeNode<T> node) {
		return node == null ? 0 : height(node.getLeft()) - height(node.getRight());
	}
	
	private TreeNode<T> rebalance(TreeNode<T> node) {
		if (getBalanceFactor(node) > 1) {
			if (getBalanceFactor(node.getLeft()) <= -1) return rotateLR(node);
			return rightRotate(node);
		} else if (getBalanceFactor(node) < -1) {
			if (getBalanceFactor(node.getRight()) >= 1) return rotateRL(node);
			return leftRotate(node);
		}
		return node;
	}
	
	private TreeNode<T> rebalanceInsert(TreeNode<T> node) {
		return rebalance(node);
	}
	
	private TreeNode<T> rebalanceRemove(TreeNode<T> node) {
		if (node != null) {
			rebalance(node);
			return rebalanceRemove(node.getParent());
		}
		return null;
	}
	
	private TreeNode<T> delPos(TreeNode<T> node, TreeNode<T> parent, T data) {
		if (node == null) {
			if (parent == null) return node;
			return parent;
		}
		else if (data.compareTo(node.getData()) < 0) return delPos(node.getLeft(), node, data);
		else if (data.compareTo(node.getData()) > 0) return delPos(node.getRight(), node, data);
		return node;
	}
	
	private TreeNode<T> leftRotate(TreeNode<T> node) {
		TreeNode<T> temp = node.getRight(), parent = node.getParent();
		node.setRight(temp.getLeft());
		if (node.getRight() != null) node.getRight().setParent(node);
		temp.setLeft(node);
		node.setParent(temp);
		if (parent != null && parent.getLeft() == node) parent.setLeft(temp);
		else if (parent != null && parent.getRight() == node) parent.setRight(temp);
		temp.setParent(parent);
	    updateHeight(node);
	    updateHeight(temp);
	    if (node == this.getRoot()) setRoot(temp);
		return temp;
	}
	
	private TreeNode<T> rightRotate(TreeNode<T> node) {
		TreeNode<T> temp = node.getLeft(), parent = node.getParent();
		node.setLeft(temp.getRight());
		if (node.getLeft() != null) node.getLeft().setParent(node);
		temp.setRight(node);
		node.setParent(temp);
		if (parent != null && parent.getLeft() == node) parent.setLeft(temp);
		else if (parent != null && parent.getRight() == node) parent.setRight(temp);
		temp.setParent(parent);
	    updateHeight(node);
	    updateHeight(temp);
	    if (node == this.getRoot()) setRoot(temp);
		return temp;
	}
	
	private TreeNode<T> rotateRL(TreeNode<T> node) {
		rightRotate(node.getRight());
		return leftRotate(node);
	}
	
	private TreeNode<T> rotateLR(TreeNode<T> node) {
		leftRotate(node.getLeft());
		return rightRotate(node);
	}
}
