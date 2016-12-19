package Tree.App;

/* Basic application employing swing library to generate a basic tree shape, */
public class Node {

	private Node parent;
	private Node leftChild;
	private Node rightChild;

	private int value;

	public Node(int value) {
		this.value = value;
	}

	public boolean insert(int newValue) {
		if (this.value == newValue)
			return false;
		else if (this.value > newValue) {
			if (leftChild == null) {
				leftChild = new Node(newValue);
				return true;
			} else {
				return leftChild.insert(newValue);
			}
		} else if (this.value < newValue) {
			if (rightChild == null) {
				rightChild = new Node(newValue);
				return true;
			} else {
				return rightChild.insert(newValue);
			}
		}
		return false;
	}

	public String toString() {
		return " " + value + " ";
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}