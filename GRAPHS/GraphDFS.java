import java.util.*;

class GraphDFS {

	public void traverseDFS(final ArrayList<ArrayList<Integer>> graph) {

		boolean[] visited = new boolean[graph.size() + 1];

		ArrayList<Integer> vistedOrder = new ArrayList<>();


		for(int i = 1; i < graph.size(); i++) {
			if (!visited[i]) {
				dft(visited, i, graph, vistedOrder);
			}
		}
		
		System.out.println(vistedOrder);
	}

	public void dft(boolean[] visited, int i, final ArrayList<ArrayList<Integer>> graph, final ArrayList<Integer> vistedOrder) {

		// Imp: Return if you have seen the node in DFS, In case of tree it is null.
		visited[i] = true;
		vistedOrder.add(i);

		for(int node: graph.get(i)) {
			if (!visited[node]) {
				dft(visited, node, graph, vistedOrder);
			}
		}

	}

	public static void main(String[] args) {

		GraphDFS graphDFS = new GraphDFS();

		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		graph.add(new ArrayList<>(Arrays.asList(0)));
		graph.add(new ArrayList<>(Arrays.asList(2)));
		graph.add(new ArrayList<>(Arrays.asList(1,3,4)));
		graph.add(new ArrayList<>(Arrays.asList(2,5)));
		graph.add(new ArrayList<>(Arrays.asList(2,6)));
		graph.add(new ArrayList<>(Arrays.asList(3)));
		graph.add(new ArrayList<>(Arrays.asList(4)));
		graph.add(new ArrayList<>(Arrays.asList(8)));
		graph.add(new ArrayList<>(Arrays.asList(7)));

		graphDFS.traverseDFS(graph);
		
	}


}