/*
 * Main Class for testing DFS
 * 
 * @methods:
    * main(String[] args): Main method to test DFS
 */

public class DFS {
    public static void main(String[] args) {
        char[] vertices = { 'A', 'B', 'C', 'D', 'E' };

        GraphDFS graph = new GraphDFS(vertices);
        graph.addEdge('A', 'B');
        graph.addEdge('A', 'C');
        graph.addEdge('B', 'C');
        graph.addEdge('B', 'D');
        graph.addEdge('C', 'E');

        graph.dfs('A');
    }
}
