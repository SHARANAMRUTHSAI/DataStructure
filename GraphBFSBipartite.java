import java.util.*;

class GraphBFSBipartite {

	public void isBipartite(final ArrayList<ArrayList<Integer>> graph) {

		int[] color = new int[graph.size()];
		Arrays.fill(color, -1);

		Queue<Integer> queue = new LinkedList<>();

		for(int node = 1; node < graph.size(); node++) {
			
			if(color[node]== -1) {
				color[node] = 1;
				queue.add(node);
			} else {
				continue;
			}

			while(!queue.isEmpty()) {
				int currentNode = queue.remove();
				for(int neighbourNode: graph.get(currentNode)) {
					if(color[neighbourNode] == -1) {
						color[neighbourNode] = (color[currentNode] > 0) ? 0 : 1;
						queue.add(neighbourNode);
					} else if (color[neighbourNode] == color[currentNode]) {
						System.out.println("Not a BiPartite Graph");
						return;
					}
				}
			}
		}

		System.out.println("BiPartite Graph");

	}


	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> graphEvenCycle = new ArrayList<ArrayList<Integer>>();
		graphEvenCycle.add(new ArrayList<>(Arrays.asList(0)));
		graphEvenCycle.add(new ArrayList<>(Arrays.asList(2)));
		graphEvenCycle.add(new ArrayList<>(Arrays.asList(1,3)));
		graphEvenCycle.add(new ArrayList<>(Arrays.asList(2,4)));
		graphEvenCycle.add(new ArrayList<>(Arrays.asList(3,5)));
		graphEvenCycle.add(new ArrayList<>(Arrays.asList(2,4)));


		ArrayList<ArrayList<Integer>> graphOddCycle = new ArrayList<ArrayList<Integer>>();
		graphOddCycle.add(new ArrayList<>(Arrays.asList(0)));
		graphOddCycle.add(new ArrayList<>(Arrays.asList(2)));
		graphOddCycle.add(new ArrayList<>(Arrays.asList(1,3,6)));
		graphOddCycle.add(new ArrayList<>(Arrays.asList(2,4)));
		graphOddCycle.add(new ArrayList<>(Arrays.asList(3,5)));
		graphOddCycle.add(new ArrayList<>(Arrays.asList(4,6)));
		graphOddCycle.add(new ArrayList<>(Arrays.asList(5,6)));




		GraphBFSBipartite graphBFSBipartite = new GraphBFSBipartite();
		graphBFSBipartite.isBipartite(graphEvenCycle);

		System.out.println("*************************************");

		graphBFSBipartite.isBipartite(graphOddCycle);


	}
}