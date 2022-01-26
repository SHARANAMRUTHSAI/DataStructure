import java.util.*;

class GraphCycleBFS {

	public boolean checkForCycle(final ArrayList<ArrayList<Integer>> graph) {

		boolean[] visited = new boolean[graph.size() + 1];

		Queue<GraphNode> fifo = new LinkedList<>();

		int count = 0;


		for(int node = 1; node < graph.size(); node++) {

            // Checking if node is visited. Used for traversing individual components.
			if(!visited[node]) {
				fifo.add(new GraphNode(node, -1));
			} else {
				continue;
			}


            // Node exploration here
			while(!fifo.isEmpty()) {
				GraphNode currentNode = fifo.remove();
				visited[currentNode.node] = true;

				// Adding connected nodes to queue. We are not exploring here.
				for(int neighbourNode : graph.get(currentNode.node)) {
					if(!visited[neighbourNode]) {
						fifo.add(new GraphNode(neighbourNode, currentNode.node));
					} else if (neighbourNode != currentNode.connectingNode) {
						System.out.println("neighbourNode: " + neighbourNode + ", currentNode.connectingNode:" + currentNode.connectingNode);
						return true;
					}
				}
			}
		}
		return false;


	}

	public static void main(String[] args) {

		GraphCycleBFS graphCycleBFS = new GraphCycleBFS();

		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		graph.add(new ArrayList<>(Arrays.asList(0)));
		graph.add(new ArrayList<>(Arrays.asList(2)));
		graph.add(new ArrayList<>(Arrays.asList(1,3,8)));
		graph.add(new ArrayList<>(Arrays.asList(2,4,7)));
		graph.add(new ArrayList<>(Arrays.asList(3,5)));
		graph.add(new ArrayList<>(Arrays.asList(4,6)));
		graph.add(new ArrayList<>(Arrays.asList(5,9)));
		graph.add(new ArrayList<>(Arrays.asList(3,9)));
		graph.add(new ArrayList<>(Arrays.asList(2)));
		graph.add(new ArrayList<>(Arrays.asList(6,7)));
		graph.add(new ArrayList<>(Arrays.asList(11)));
		graph.add(new ArrayList<>(Arrays.asList(10)));

		System.out.println(graphCycleBFS.checkForCycle(graph));
		
	}



}