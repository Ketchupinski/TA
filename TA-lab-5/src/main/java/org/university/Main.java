package org.university;

import org.university.algorithm.DijkstraAlg;
import org.university.algorithm.FloydMinPathMatrix;
import org.university.file.FileService;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws Exception{
        FileService file = new FileService();
        int[][] matrix = file.getWeightedGraphFromFile(Path.of("src/main/resources/djkstra_graph.txt"));
        MatrixService mService = new MatrixService();
        WeightedMatrix weightedMatrix = new WeightedMatrix(matrix);
        mService.printMatrix(weightedMatrix.getMatrix());
        DijkstraAlg.findShortestPath(weightedMatrix.getN(), weightedMatrix.getMatrix(), 2, 1);

        System.out.println("=============================================");
        System.out.printf("Floyd-Warshall algorithm%n");
        System.out.println("=============================================");
        matrix = file.getWeightedGraphFromFile(Path.of("src/main/resources/floyd_graph.txt"));
        weightedMatrix = new WeightedMatrix(matrix);
        FloydMinPathMatrix floydMinPathMatrix = new FloydMinPathMatrix(weightedMatrix);
        int[][] path = floydMinPathMatrix.getPathMatrix();
        System.out.println("Path matrix:");
        mService.printMatrix(path);

    }
}