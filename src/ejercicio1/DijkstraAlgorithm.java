package ejercicio1;

public class DijkstraAlgorithm {


    int minDistance(int dist[], boolean sptSet[], int V) {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }


    void printSolution(int dist[], int V) {
        System.out.println("Vertex 		 Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " 		 " + dist[i]);
    }


    void dijkstra(int graph[][], int src, int V) {
        int dist[] = new int[V];


        boolean sptSet[] = new boolean[V];


        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }


        dist[src] = 0;


        for (int count = 0; count < V - 1; count++) {

            int u = minDistance(dist, sptSet, V);

            sptSet[u] = true;


            for (int v = 0; v < V; v++)


                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }


        printSolution(dist, V);
    }

    public static void main(String[] args) {

        int graph[][] = new int[][] {
                { 0, 10, 0, 0, 0, 0 },
                { 10, 0, 5, 0, 0, 0 },
                { 0, 5, 0, 20, 1, 0 },
                { 0, 0, 20, 0, 2, 2 },
                { 0, 0, 1, 2, 0, 3 },
                { 0, 0, 0, 2, 3, 0 }
        };
        int V = graph.length;

        DijkstraAlgorithm t = new DijkstraAlgorithm();
        t.dijkstra(graph, 0, V);
    }
}
