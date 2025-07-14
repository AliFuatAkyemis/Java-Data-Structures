
public class ArrayAVL<T extends Comparable<? super T>> extends ArrayBST<T> {
	private T[] array = super.getArray();
	
	@Override
	protected void insertRec(int index, T data) {
		super.insertRec(index, data);
		rebalance(index);
	}

	private int getBalanceFactor(int index) {
		return this.array[index] == null ? 0 : getHeight(left(index)) - getHeight(right(index));
	}
	
	private void rebalance(int index) {
		if (getBalanceFactor(index) > 1) {
			if (getBalanceFactor(left(index)) < 0) rotationLR(index);
			else rightRotation(index);
		} else if (getBalanceFactor(index) < -1) {
			if (getBalanceFactor(right(index)) > 0) rotationRL(index);
			else leftRotation(index);
		}
	}
	
	private void repositionDown(int index) {
		if (index%2 == 1) {
			if (this.array[left(index)] != null) repositionDown(left(index));
			this.array[left(index)] = this.array[index];
		} else {
			if (this.array[right(index)] != null) repositionDown(right(index));
			this.array[right(index)] = this.array[index];
		}
	}
	
	private void repositionUp(int index) {
		if (this.array[index] == null) return;
		if (index%2 == 1) {
			if (this.array[leftParent(index)] == null) this.array[leftParent(index)] = this.array[index];
			repositionUp(left(index));
		} else {
			if (this.array[rightParent(index)] == null) this.array[rightParent(index)] = this.array[index];
			repositionUp(right(index));
		}
	}
	
	private void leftRotation(int index) {
		if (this.array[left(index)] != null) repositionDown(left(index));
		this.array[left(index)] = this.array[index];
		repositionUp(right(index));
	}
	
	private void rightRotation(int index) {
		if (this.array[right(index)] != null) repositionDown(right(index));
		this.array[right(index)] = this.array[index];
		repositionUp(left(index));
	}
	
	private void rotationRL(int index) {
		rightRotation(right(index));
		leftRotation(index);
	}
	
	private void rotationLR(int index) {
		leftRotation(left(index));
		rightRotation(index);
	}
}
