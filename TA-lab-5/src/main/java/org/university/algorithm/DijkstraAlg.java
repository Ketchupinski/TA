package org.university.algorithm;


import org.university.Towns;

/**
 * Using Dijkstra's algorithm to find the shortest path between two vertices in a weighted graph.
 * Weighted graph is represented as an adjacency matrix with two directions.
 * Algorithm is implemented as a class with a method that finds the shortest path between two vertices.
 * Every vertex have two directions of edges (u,v) and (v,u) with the not equal weights.
 * Algorithm must find the shortest path between two vertices in a weighted graph.
 * @author Arsen Savshak
 * @version 1.0
 */
public class DijkstraAlg {

    /**
     * Implementation of Dijkstra's algorithm to find the shortest path between two vertices in a weighted graph with two directions of edges.
     * Write all paths to console. Write the shortest path to console. Write the shortest path length to console.
     * @param n - number of vertices in a graph
     * @param weightedMatrix weighted graph with two directions of edges (u,v) and (v,u) with the not equal weights
     * @param start start vertex of the path (u)
     * @param end end vertex of the path (destination)
     * @return the shortest path between two vertices
     */
    public static int[] findShortestPath(int n, int[][] weightedMatrix, int start, int end) {
        int[] path = new int[n + 1];
        int[] distance = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            distance[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        distance[start] = 0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int j = 1; j <= n; j++) {
                if (!visited[j] && distance[j] < min) {
                    min = distance[j];
                    minIndex = j;
                }
            }

            visited[minIndex] = true;
            for (int j = 1; j <= n; j++) {
                int temp = weightedMatrix[minIndex][j] == Integer.MAX_VALUE ? Integer.MAX_VALUE : (min + weightedMatrix[minIndex][j]);
                if (!visited[j] && temp < distance[j]) {
                    distance[j] = temp;
                    path[j] = minIndex;
                }
            }
        }

        System.out.println("All paths:");
        for (int i = 1; i <= n; i++) {
            if (i != start) {
                System.out.print(Towns.getTownNameById(start) + " -> " + Towns.getTownNameById(i) + " = " + distance[i]);
                System.out.print(" Path: " + Towns.getTownNameById(i));
                int j = i;
                do {
                    j = path[j];
                    System.out.print(" <- " + Towns.getTownNameById(j));
                } while (j != start);
                System.out.println();
            }
        }

        System.out.println("The shortest path from " + Towns.getTownNameById(start) + " to " + Towns.getTownNameById(end) + " is " + distance[end]);
        System.out.print(Towns.getTownNameById(start) + " -> " + Towns.getTownNameById(end) + " = " + distance[end]);
        System.out.print(" Path: " + Towns.getTownNameById(end));
        int j = end;
        do {
            j = path[j];
            System.out.print(" <- " + Towns.getTownNameById(j));
        } while (j != start);
        System.out.println();
        return path;
    }
}
