package Tree.App;

import java.util.ArrayList;
import java.util.List;

public class Node {

	private Node parent;
	private Node leftChild;
	private Node rightChild;
	
	private List<Node> children = new ArrayList<Node>();

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}

	private int value, x, y;

	public Node(int value, int x, int y) {
		this.value = value;
		this.x = x;
		this.y = y;
	}

	public boolean insert(int newValue) {
		if (this.value == newValue)
			return false;
		else {
			int xD = (int)(Math.random() * 40+5);
			int yD = (int)(Math.random() * 40)+5;
			if (this.value > newValue) {			
				if (leftChild == null) {
					leftChild = new Node(newValue, this.x-xD, this.y-yD);
					children.add(leftChild);
					return true;
				} else {
					return leftChild.insert(newValue);
				}
			} else if (this.value < newValue) {
				if (rightChild == null) {
					rightChild = new Node(newValue, this.x, this.y-yD);
					children.add(rightChild);
					return true;
				} else {
					return rightChild.insert(newValue);
				}
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
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
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