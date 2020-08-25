package org.serieznyi.maze;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MazeGenerator {
    public int[][] generate(int width, int height)
    {
        Node[][] maze = new Node[width][height];

        for (int y = 0; y < maze.length; y++) {
            for (int x = 0; x < maze[y].length; x++) {

                maze[x][y] = new Node(x, y);

                List<Node> neig = new ArrayList<>();

                if (indexInBound(maze, x, y - 1)) {
                    neig.add(new Node(x, y - 1));
                }

                if (indexInBound(maze, x - 1, y)) {
                    neig.add(new Node(x - 1, y));
                }

                if (neig.size() > 0) {
                    maze[x][y].connect = neig.get(ThreadLocalRandom.current().nextInt(0, neig.size()));
                }
            }
        }

        int[][] data = new int[width * 2 - 1][height * 2 - 1];

        for (int y = 0; y < maze.length; y++) {
            for (int x = 0; x < maze[y].length; x++) {
                Node node = maze[x][y];
                Node connected = maze[x][y].connect;

                int newX = node.x * 2;
                int newY = node.y * 2;

                data[newX][newY] = 1;

                if (connected != null) {
                    int newCoX = connected.x * 2;
                    int newCoY = connected.y * 2;

                    data[newCoX][newCoY] = 1;

                    int xa = (newX + newCoX) / 2;
                    int ya = (newY + newCoY) / 2;

                    data[xa][ya] = 1;
                }
            }
        }

        int[][] data2 = new int[data.length + 1][data[0].length + 1];

        for (int y = 0; y < data2.length; y++) {
            for (int x = 0; x < data2[y].length; x++) {
                if (x != 0 && y != 0 && x != data2.length - 1 && y != data2[y].length - 1) {
                    data2[x][y] = data[x - 1][y - 1];
                }
            }
        }

        return data2;
    }

    public static boolean indexInBound(Node[][] arrays, int x, int y){
        return arrays != null && x >= 0 && x < arrays.length && y >= 0 && y < arrays[x].length;
    }

    static class Node {
        public Node connect;
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
