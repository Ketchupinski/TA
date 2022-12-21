package org.university.algorithm;

import org.university.MatrixService;
import org.university.WeightedMatrix;

/**
 * Realization of Floyd-Warshall algorithm for finding the shortest path between all pairs of vertices in a weighted graph.
 * Weighted graph is represented as an adjacency matrix with two directions.
 * Algorithm is implemented as a class with a method that finds the shortest path between all pairs of vertices.
 * Every vertex have two directions of edges (u,v) and (v,u) with the not equal weights.
 * Algorithm must return table of shortest paths between all pairs of vertices in a weighted graph.
 * Also, algorithm must write all paths (even incorrect) to console.
 */
public class FloydMinPathMatrix {
    private final int[][][] minWeightMatrix;
    private final int[][] pathMatrix;
    public final int inf = Integer.MAX_VALUE;
    public FloydMinPathMatrix(WeightedMatrix w) {
        int n = w.getN();
        int[][][] matrix = new int[n + 1][n + 1][n + 1];
        for(int i = 0; i < w.getN(); i++) {
            matrix[i] = w.getMatrix();
        }
        int[][] pMatrix = createPathMatrix(n);
        MatrixService mService = new MatrixService();
        mService.printMatrix(matrix[0]);
        System.out.println();
        for (int k = 1; k <= n - 1; k++) {
            for (int i = 1; i <=n; i++) {
                for (int j = 1; j <=n; j++) {
                    if (matrix[k - 1][i][k] != inf && matrix[k - 1][k][j] != inf) {
                        if ((matrix[k - 1][i][k] + matrix[k - 1][k][j]) < matrix[k - 1][i][j]) {
                            matrix[k][i][j] = (matrix[k - 1][i][k] + matrix[k - 1][k][j]);
                            pMatrix[i][j] = k;
                        }
                    }
                }
            }
            System.out.println("k: " + k);
            mService.printMatrix(matrix[k]);
        }

        this.minWeightMatrix = matrix;
        this.pathMatrix = pMatrix;
    }

    private int[][] createPathMatrix(int n) {
        int[][] T = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=n; j++) {
                if (i == j) {
                    T[i][j] = 0;
                }
                else {
                    T[i][j] = i;
                }
            }
        }
        return T;
    }

    /**
     * Find path from <code>v</code> to <code>u</code>
     * @param v start top
     * @param u end top
     * @return min path
     */
    public String getPath(int v, int u) {
        if (pathMatrix[v][u] == v) {
            return " " + v;
        }

        int n = this.pathMatrix.length;
        StringBuilder path = new StringBuilder();
        int next = u;
        for(int j = 1; j < n; j++) {
            if (pathMatrix[v][next] != v) {
                path.append(next).append(" ");
                next = pathMatrix[v][next];
            }
            else {
                path.append(next).append(" ").append(v).append(" ");
                return path.reverse().toString();
            }
        }
        return ""; // unreal scenario
    }

    public int[][] getPathMatrix() {
        return pathMatrix;
    }
}
