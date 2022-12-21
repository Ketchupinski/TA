package org.university.file;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class FileService {
    private static Scanner scan;


    public int[][] getWeightedGraphFromFile(Path path) throws IOException {
        scan = new Scanner(path);
        int n = scan.nextInt(); // number of vertices of the graph
        int m = scan.nextInt(); // number of edges of the graph
        int[][] fileGraphInfo = new int[m + 1][3];
        fileGraphInfo[0][0] = n;
        fileGraphInfo[0][1] = m;
        fileGraphInfo[0][2] = 0; // weight of the graph

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= 2; j++) {
                fileGraphInfo[i][j] = scan.nextInt();
            }
        }
        return fileGraphInfo;
    }
}
