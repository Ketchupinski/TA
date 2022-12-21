package org.university;

public class MatrixService {
    private static final int INF = Integer.MAX_VALUE;
    public void printMatrix(int[][] matrix) {
        int[] temp = matrix[0];
        int hL = matrix.length;
        int wL = temp.length;
        System.out.print("   | ");
        for (int i = 1; i < wL; i++){
            System.out.printf("%-2d | ", i);
        }
        System.out.println();
        for (int i = 1; i < hL; i++) {
            System.out.printf("%-2d | ", i);
            for (int j = 1; j < wL; j++) {
                if (matrix[i][j] != INF) {
                    System.out.printf("%-2d | ", matrix[i][j]);
                }
                else {
                    char symbol = 0x221E;
                    System.out.printf("%-2c | ", symbol);
                }
            }
            System.out.println();
        }
    }

    public int[] fillVerticesAsSet(int n) {
        int[] vertices = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            vertices[i] = i;
        }
        return vertices;
    }
}
