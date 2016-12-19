	
	package Tree.App;



	/* Basic Node. Node represents any external or internal node including tree root. */
	public interface Tree {
		
		/*Get root node of tree*/
		public Node getRoot();
		
		/*find node with value x.*/
		public Node getNode(int nodeVal);
		
		
		/*Add node to tree. Returns reference to the added node*/
		public Node AddNode(Node parentNode, Node childNode);
		
		/*Remove Node from tree */
		public Node removeNode(Node toRemove);
		
		

			
}