import java.util.*;

class GraphBFS {

	// BFS

	public void traverseBFS(final ArrayList<ArrayList<Integer>> graph) {

        boolean visited[] = new boolean[graph.size() + 1];

        Queue<Integer> fifo = new LinkedList<>();

        ArrayList<Integer> visitedOrder = new ArrayList<>();



        for(int i = 1; i< graph.size(); i++) {

         
        // select a node only it is not explored
        if(!visited[i]) {
        	fifo.add(i);
        } else {
        	continue;
        }


        // Node exploration here.
        while(!fifo.isEmpty()) {
        	int exploreNode = fifo.remove();
        	visited[exploreNode] = true;
        	visitedOrder.add(exploreNode);
        	for(int neighbourNode: graph.get(exploreNode)) {
        		if(!visited[neighbourNode]) {
        			fifo.add(neighbourNode);
        		}
        	}
        }

        }
		System.out.println(visitedOrder);
	}


	public static void main(String[] args) {

		GraphBFS graphBFS = new GraphBFS();

		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		graph.add(new ArrayList<>(Arrays.asList(0)));
		graph.add(new ArrayList<>(Arrays.asList(2,3)));
		graph.add(new ArrayList<>(Arrays.asList(1,5,6)));
		graph.add(new ArrayList<>(Arrays.asList(1)));
		graph.add(new ArrayList<>(Arrays.asList(5)));
		graph.add(new ArrayList<>(Arrays.asList(2,4)));
		graph.add(new ArrayList<>(Arrays.asList(2)));
		graph.add(new ArrayList<>(Arrays.asList(8)));
		graph.add(new ArrayList<>(Arrays.asList(7,9)));
		graph.add(new ArrayList<>(Arrays.asList(8)));

		graphBFS.traverseBFS(graph);

		
	}


}