/**
 * OneWayDoor: Only one way door we cannot shrink the matrix as we are using indexs are nodes.
 * Inefficient memory allocation: Even for no edge memory is allocated in the matrix.
 * Costly operations: Increasing the matrix size is a costly operation...
 *  
 */



class AdjacencyMatrixGraph {

    int[][] graph;

    int nodes;

    public AdjacencyMatrixGraph(int nodes) {
    	this.nodes = nodes;
    	graph = new int[nodes + 1][nodes + 1];

    }

	public static void main(String[] args) {
		AdjacencyMatrixGraph adjacencyMatrixGraph = new AdjacencyMatrixGraph(5);
		adjacencyMatrixGraph.doTest(adjacencyMatrixGraph);
		
	}


	public void doTest(final AdjacencyMatrixGraph adjacencyMatrixGraph){

		/*
		0 0 0 0 0 
		1 0 0 0 0 
		0 0 0 0 0 
		0 0 0 0 0 
		0 0 0 0 0 
		*/
		adjacencyMatrixGraph.printAdjacencyMatrix();
		System.out.println();


		/*
		0 1 0 0 0 
		1 0 0 1 0 
		0 0 0 0 1 
		0 1 0 0 0 
		0 0 1 0 0 
		*/
		adjacencyMatrixGraph.addEdge(1,2);
		adjacencyMatrixGraph.addEdge(3,5);
		adjacencyMatrixGraph.addEdge(2,4);
		adjacencyMatrixGraph.printAdjacencyMatrix();



		/*
		0 -1 0 0 0 
		-1 -1 -1 -1 -1 
		0 -1 0 0 1 
		0 -1 0 0 0 
		0 -1 1 0 0 
		*/
		adjacencyMatrixGraph.deleteNode(2);
		System.out.println();
		adjacencyMatrixGraph.printAdjacencyMatrix();


        System.out.println();
        try {
        	adjacencyMatrixGraph.addEdge(2, 1);
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }


		/*
		0 0 0 0 0 
		0 0 0 0 0 
		0 0 0 0 1 
		0 0 0 0 0 
		0 0 1 0 0 
		*/
		adjacencyMatrixGraph.addNode(2);
		System.out.println();
		adjacencyMatrixGraph.printAdjacencyMatrix();


		/*
		0 0 0 0 0 
		0 0 0 1 0 
		0 0 0 0 1 
		0 1 0 0 0 
		0 0 1 0 0 
		*/
		System.out.println();
		adjacencyMatrixGraph.addEdge(4,2);
		adjacencyMatrixGraph.printAdjacencyMatrix();


        try {
        	adjacencyMatrixGraph.addEdge(4, 2);
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }

        /*
        0 0 0 0 0 0 0 
		0 0 0 1 0 0 0 
		0 0 0 0 1 0 0 
		0 1 0 0 0 0 0 
		0 0 1 0 0 0 0 
		0 0 0 0 0 0 0 
		0 0 0 0 0 0 0 
        */
        adjacencyMatrixGraph.addNode(7);
		System.out.println();
		adjacencyMatrixGraph.printAdjacencyMatrix();

        /*
        0 0 0 0 0 0 1 
		0 0 0 1 0 0 0 
		0 0 0 0 1 0 0 
		0 1 0 0 0 0 0 
		0 0 1 0 0 0 0 
		0 0 0 0 0 0 0 
		1 0 0 0 0 0 0 
        */
		System.out.println();
		adjacencyMatrixGraph.addEdge(7,1);
		adjacencyMatrixGraph.printAdjacencyMatrix();


        System.out.println();
		try {
        	adjacencyMatrixGraph.addEdge(14, 2);
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }

        // 2
        System.out.println();
        adjacencyMatrixGraph.getNodeDegree(1);



		System.out.println();
		System.out.println(adjacencyMatrixGraph.getNodeDegree(1));

	}


	public void addNode(final int node) {

		if (node < nodes) {
			// Already node added once......
			if(graph[node][node] == -1) {
				for(int i=1; i<=nodes; i++){
					this.graph[node][i] = 0;
					this.graph[i][node] = 0;
				}
				return;
			} else {
				throw new UnsupportedOperationException("Node:"+ node +" already present.....");
			}
		}

        // Adding new node to the graph.......
		int[][] newGraph = new int[node + 1][node + 1];
		for(int i=1; i<=nodes; i++){
			for(int j=1;j<=nodes;j++) {
				newGraph[i][j] = graph[i][j];
			}
		}
		this.nodes = node;
		this.graph = newGraph;
	}

	public void deleteNode(final int node) {
		for(int i=1; i<=nodes; i++){
			this.graph[node][i] = -1;
			this.graph[i][node] = -1;
		}
	}

	public void addEdge(int source, int destination) {

		if(source > nodes || destination > nodes) {
			throw new UnsupportedOperationException("Invalid source:" + source + " destination:" + destination);
		}


		if (graph[source][destination] == -1) {
			throw new UnsupportedOperationException("Node doesn't exist......");
		}

		if (graph[source][destination] == 1) {
			throw new UnsupportedOperationException("Edge already exist between source:" + source + " destination:" + destination);	
		}

		this.graph[source][destination] = 1;
		this.graph[destination][source] = 1;
	}

	public void deleteEdge(int source, int destination) {

		if(source > nodes || destination > nodes) {
			throw new UnsupportedOperationException("Invalid source:" + source + " destination:" + destination);
		}

		if (graph[source][destination] == -1) {
			throw new UnsupportedOperationException("Node doesn't exist......");
		} 

		if (graph[source][destination] == 0) {
			throw new UnsupportedOperationException("No edge exist between source:" + source + " destination:" + destination);	
		}


		this.graph[source][destination] = -1;
		this.graph[destination][source] = -1;
	}

    public void printAdjacencyMatrix() {
		for(int i=1; i<=nodes; i++){
			for(int j=1;j<=nodes;j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}

	public int getNodeDegree(int node) {

		if (graph[node][node] == -1) {
			throw new UnsupportedOperationException("Node doesn't exist......");
		}

        int degree = 0;
		for (int i=1; i<=nodes; i++) {
			degree = degree + graph[node][i];
		}
		return 2*degree;

	}
	
}