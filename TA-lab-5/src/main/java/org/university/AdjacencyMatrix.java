package org.university;

import java.util.Arrays;

/**
 * Create adjacency matrix from list of edges of the weighted graph.
 * The matrix is represented as a two-dimensional array with weights of the edges.
 * The first row and column of the matrix are used to store the number of vertices and edges of the graph.
 */
public class AdjacencyMatrix {
    private final int[][] matrix;
    private final int n;
    private final int m;

    public AdjacencyMatrix(int[][] matrix, int n, int m) {
        this.matrix = matrix;
        this.n = n;
        this.m = m;
    }

    /**
     * Create adjacency matrix from list of edges of the weighted graph.
     * The matrix is represented as a two-dimensional array with weights of the edges.
     * The first row and column of the matrix are used to store the number of vertices and edges of the graph.
     *
     * @return adjacency matrix of the weighted graph
     */
    public int[][] createMatrix() {
        int[][] A = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int[] v = {i, j};
                for (int r = 1; r <= m; r++) {
                    int[] k = {matrix[r][0], matrix[r][1]};
                    if (Arrays.equals(v, k)) {
                        A[i][j] = matrix[r][2];
                        break;
                    }
                }
            }
        }
        return A;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }
}