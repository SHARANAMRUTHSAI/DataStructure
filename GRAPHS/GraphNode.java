class GraphNode {

	public int node;

	public int connectingNode;

	public GraphNode(int node, int connectingNode) {
		this.node = node;
		this.connectingNode = connectingNode;
	}

	public String toString() {//overriding the toString() method  
	 	return "Node: " + node + ",ConnectingNode: "+ connectingNode;  
	}
}