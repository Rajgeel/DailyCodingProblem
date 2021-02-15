// Given an undirected graph represented as an adjacency matrix and an integer k, write a function to determine whether each vertex 
// in the graph can be colored such that no two adjacent vertices share the same color using at most k colors.



// Time complexity is O(m^v) and space complexity is O(v).
class ColoredUndirectedGraphVerticesAtmostKColor {
	
	final int V = 4;
    int color[];
 
    boolean isSafe(int v, int graph[][], int color[], int c) {
        for(int i = 0; i < V; i++) {
            if(graph[v][i] == 1 && c == color[i]) {

                return false;
            }
        }
        return true;
    }
 
    boolean graphColoringUtil(int graph[][], int m, int color[], int v) {

        if(v == V) {

            return true;
        }
 
        for(int c = 1; c <= m; c++) {

            if (isSafe(v, graph, color, c)) {

                color[v] = c;
 
                if (graphColoringUtil(graph, m, color, v + 1)) {

                    return true;
                }
 
                color[v] = 0;
            }
        }
 
        return false;
    }
 
    boolean graphColoring(int graph[][], int m) {
 
        color = new int[V];

        for(int i = 0; i < V; i++) {

            color[i] = 0;
        }

        if(!graphColoringUtil(graph, m, color, 0)) {

            System.out.println("Solution does not exist");

            return false;
        }

        print(color);

        return true;
    }
 
    void print(int color[])
    {
        System.out.println("Solution Exists: Following" + " are the assigned colors");

        for(int i = 0; i < V; i++) {

            System.out.print(" " + color[i] + " ");
        }

        System.out.println();
    }
 
    public static void main(String... s){

        ColoredUndirectedGraphVerticesAtmostKColor Coloring = new ColoredUndirectedGraphVerticesAtmostKColor();
     
        int graph[][] = {
            { 0, 1, 1, 1 },
            { 1, 0, 1, 0 },
            { 1, 1, 0, 1 },
            { 1, 0, 1, 0 },
        };

        int m = 3;

        Coloring.graphColoring(graph, m);
    }
}