import java.util.*;

class GraphBFS {



	public void traverseBFS(final ArrayList<ArrayList<Integer>> graph) {

        boolean visited[] = new boolean[graph.size() + 1];

        Queue<Integer> fifo = new LinkedList<>();

        ArrayList<Integer> visitedOrder = new ArrayList<>();


		for(int i = 1; i < graph.size(); i++) {


			//check if node is visited 
			if(!visited[i]) {
				visited[i] = true;
				visitedOrder.add(i); 
			}

            // Add all connecting nodes to FIFO
		    for(int node: graph.get(i)) {
					fifo.add(node);
			}

            // Peek every element from FIFO and visit them.
			while(fifo.peek() != null) {
				int node = fifo.remove();
				if(!visited[node]) {
					visitedOrder.add(node);
					visited[node] = true;
				}
			}
			System.out.println(visitedOrder);

		}
		System.out.println(visitedOrder);
	}


	public static void main(String[] args) {

		GraphBFS graphBFS = new GraphBFS();

		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		graph.add(new ArrayList<>(Arrays.asList(0)));
		graph.add(new ArrayList<>(Arrays.asList(2,3)));
		graph.add(new ArrayList<>(Arrays.asList(1,6)));
		graph.add(new ArrayList<>(Arrays.asList(1)));
		graph.add(new ArrayList<>(Arrays.asList(5)));
		graph.add(new ArrayList<>(Arrays.asList(2,4)));
		graph.add(new ArrayList<>(Arrays.asList(2)));
		graph.add(new ArrayList<>(Arrays.asList(8)));
		graph.add(new ArrayList<>(Arrays.asList(7)));
		graph.add(new ArrayList<>(Arrays.asList(8)));

		graphBFS.traverseBFS(graph);

		
	}


}