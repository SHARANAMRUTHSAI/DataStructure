import java.util.*;

class GraphCycleDFS {



	public boolean checkForCycle(final ArrayList<ArrayList<Integer>> graph) { 

		boolean[] visited = new boolean[graph.size() + 1];

		for(int i = 1; i < graph.size(); i++) {
			// DO DFS only if it is visited.
			if(!visited[i]) {
				// Dont return instantly, there can be other connected components with cycles.
				if(dft(new GraphNode(i, -1), graph, visited)) {
					return true;
				}
			}
		}
        // Return false if there is no connected components.
		return false;
	}


	public boolean dft(final GraphNode currentNode, final ArrayList<ArrayList<Integer>> graph, final boolean[] visited){

		System.out.println(currentNode);

        // First mark it is as visited.
		visited[currentNode.node] = true;
		
		// 
		for(int neighbourNode: graph.get(currentNode.node)){
			if(!visited[neighbourNode]) {
				dft(new GraphNode(neighbourNode, currentNode.node), graph, visited);
			} else if (neighbourNode != currentNode.connectingNode) {
				System.out.println("Its cycle break..");
				return true;
			}
		}

		return false;
	}


	public static void main(String[] args) {

		GraphCycleDFS graphDFS = new GraphCycleDFS();

		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		graph.add(new ArrayList<>(Arrays.asList(0)));
		graph.add(new ArrayList<>(Arrays.asList(2)));
		graph.add(new ArrayList<>(Arrays.asList(1,3,4)));
		graph.add(new ArrayList<>(Arrays.asList(2,5)));
		graph.add(new ArrayList<>(Arrays.asList(2,6)));
		graph.add(new ArrayList<>(Arrays.asList(3,7)));
		graph.add(new ArrayList<>(Arrays.asList(4)));
		graph.add(new ArrayList<>(Arrays.asList(5,8,9)));
		graph.add(new ArrayList<>(Arrays.asList(7,9,13)));
		graph.add(new ArrayList<>(Arrays.asList(7,8)));
		graph.add(new ArrayList<>(Arrays.asList(11,12)));
		graph.add(new ArrayList<>(Arrays.asList(10,12)));
		graph.add(new ArrayList<>(Arrays.asList(10,11)));
		graph.add(new ArrayList<>(Arrays.asList(8)));

		System.out.println(graphDFS.checkForCycle(graph));
		
	}



}