package ejercicio1;

import ejercicio1.DijkstraAlgorithm;

import java.util.*;

public class serieDijstra {

    int minDistance(int dist[], boolean sptSet[], int V) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    void printSolution(int dist[], int V) {
        System.out.println("distancia \t\t del vertice desde la fuente");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
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
        Scanner scanner = new Scanner(System.in);

        System.out.println("ingresa el numero de nodos :");
        int V = scanner.nextInt();

        int graph[][] = new int[V][V];

        System.out.println("ingrese el numero de aristas:");
        int E = scanner.nextInt();

        System.out.println("Introduzca las aristas y sus pesos (formato: u v w):");
        for (int i = 0; i < E; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            graph[u][v] = w;
            graph[v][u] = w;
        }

        System.out.println("Ingrese el vértice de origen:");
        int src = scanner.nextInt();

        DijkstraAlgorithm t = new DijkstraAlgorithm();
        t.dijkstra(graph, src, V);
    }
}
