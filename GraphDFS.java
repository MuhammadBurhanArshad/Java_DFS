/*
 * Graph class for DFS using adjacency matrix
 * 
 * @variables:
    * vertices: Array of vertices
    * adjacencyMatrix: Adjacency matrix representation
    * vertexCount: Number of vertices
 *
 * @methods:
    * GraphDFS(char[] vertexLabels): Constructor to initialize the graph with vertex labels
    * addEdge(char u, char v): Method to add an edge between vertices u and v
    * getIndex(char vertex): Method to get the index of a vertex
    * dfs(char startVertex): Method to perform DFS traversal starting from a given vertex
 */

class GraphDFS {
    private Vertex[] vertices;
    private int[][] adjacencyMatrix;
    private int vertexCount;

    public GraphDFS(char[] vertexLabels) {
        vertexCount = vertexLabels.length;
        vertices = new Vertex[vertexCount];
        adjacencyMatrix = new int[vertexCount][vertexCount];

        for (int i = 0; i < vertexCount; i++) {
            vertices[i] = new Vertex(vertexLabels[i]);
            for (int j = 0; j < vertexCount; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }
    }

    public void addEdge(char u, char v) {
        int uIndex = getIndex(u);
        int vIndex = getIndex(v);
        if (uIndex != -1 && vIndex != -1) {
            adjacencyMatrix[uIndex][vIndex] = 1;
            adjacencyMatrix[vIndex][uIndex] = 1;
        }
    }

    private int getIndex(char vertex) {
        for (int i = 0; i < vertexCount; i++) {
            if (vertices[i].label == vertex) {
                return i;
            }
        }
        return -1;
    }

    public void dfs(char startVertex) {
        int startIndex = getIndex(startVertex);
        if (startIndex == -1) {
            System.out.println("Start vertex not found");
            return;
        }

        CustomStack stack = new CustomStack(vertexCount);

        vertices[startIndex].visited = true;
        stack.push(vertices[startIndex]);

        System.out.print("DFS Traversal: ");

        while (!stack.isEmpty()) {
            Vertex currentVertex = stack.peek();
            int currentIndex = getIndex(currentVertex.label);

            boolean foundUnvisitedNeighbor = false;
            for (int i = 0; i < vertexCount; i++) {
                if (adjacencyMatrix[currentIndex][i] == 1 && !vertices[i].visited) {
                    vertices[i].visited = true;
                    stack.push(vertices[i]);
                    System.out.print(vertices[i].label + " ");
                    foundUnvisitedNeighbor = true;
                    break;
                }
            }

            if (!foundUnvisitedNeighbor) {
                stack.pop();
            }
        }

        System.out.println();
    }
}
