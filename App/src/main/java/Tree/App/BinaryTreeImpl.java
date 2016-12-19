package Tree.App;

import java.util.LinkedList;
import java.util.Queue;

/* Basic Node. Node represents any external or internal node including tree root. */
public class BinaryTreeImpl {

	private Node root;

	/* Get root node of tree */
	public Node getRoot() {
		return this.root;

	}

	public void addNode(int value) {
		if (root == null) {
			root = new Node(value);
			return;
		} else {
			root.insert(value);
		}
	}

	public Node searchTree(Node node, int value) {
		if (node == null)
			return null;
		if (node.getValue() == value)
			return node;
		if (node.getValue() > value)
			return searchTree(node.getLeftChild(), value);
		else
			return searchTree(node.getLeftChild(), value);
	}

	public String printTree(Node node) {
		if (node == null)
			return null;
		else
			System.out.println(node.getValue());
		return node.toString() + printTree(node.getLeftChild()) + printTree(node.getRightChild());
	}

	public void printTreeInOrder() {
		Queue<Node> q = new LinkedList<Node>();
		if (root != null)
			q.add(root);
		while (!q.isEmpty()) {
			Node n = q.remove();
			System.out.println(n.toString());
			if (n.getLeftChild() != null)
				q.add(n.getLeftChild());
			if (n.getRightChild() != null)
				q.add(n.getRightChild());
		}
	}

	/*
	 * Find the depth of a given node. Remember, depth is length of path from
	 * node n to root.
	 */
	public int getDepth(Node node) {
		int depth = 0;
		while (node != root) {
			node = node.getParent();
			depth++;
		}
		return depth;
	}

	/*
	 * Height of a node n is the lenght of the longest path from n to one of its
	 * descendants.
	 */
	public int getHeight(Node node) {
		if (node == null)
			return -1;
		return 1 + Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()));
	}

	public int getSize(Node node) {
		if (node == null)
			return 0;
		return 1 + getSize(node.getLeftChild()) + getSize(node.getRightChild());
	}

}
