package org.serieznyi.maze;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class MazeGenerator {
    public Maze generate(int width, int height)
    {
        Node[][] maze = makeMaze(width, height);

        int[][] intMaze = mazeToIntArray(maze);

        int[][] withWalls = addWallsAround(intMaze);

        return new Maze(withWalls);
    }

    private int[][] addWallsAround(int[][] maze) {
        int[][] mazeWithWalls = new int[maze.length + 1][maze[0].length + 1];

        for (int y = 0; y < mazeWithWalls.length; y++) {
            for (int x = 0; x < mazeWithWalls[y].length; x++) {
                if (x != 0 && y != 0 && x != mazeWithWalls.length - 1 && y != mazeWithWalls[y].length - 1) {
                    mazeWithWalls[x][y] = maze[x - 1][y - 1];
                }
            }
        }

        return mazeWithWalls;
    }

    private int[][] mazeToIntArray(Node[][] maze) {
        int[][] intMaze = new int[maze.length * 2 - 1][maze[0].length * 2 - 1];

        for (int y = 0; y < maze.length; y++) {
            for (int x = 0; x < maze[y].length; x++) {
                Node node = maze[x][y];
                Node connected = maze[x][y].connect;

                int newX = node.x * 2;
                int newY = node.y * 2;

                intMaze[newX][newY] = 1;

                if (connected != null) {
                    int newCoX = connected.x * 2;
                    int newCoY = connected.y * 2;

                    intMaze[newCoX][newCoY] = 1;

                    int xa = (newX + newCoX) / 2;
                    int ya = (newY + newCoY) / 2;

                    intMaze[xa][ya] = 1;
                }
            }
        }

        return intMaze;
    }

    private Node[][] makeMaze(int width, int height) {
        Node[][] maze = new Node[width][height];

        for (int y = 0; y < maze.length; y++) {
            for (int x = 0; x < maze[y].length; x++) {

                Node node = maze[x][y] = new Node(x, y);

                getAnyNeighbor(maze, node).ifPresent(n -> node.connect = n);
            }
        }

        return maze;
    }

    private Optional<Node> getAnyNeighbor(Node[][] maze, Node node) {
        List<Node> neighbors = getNeighborsFor(maze, node);

        if (neighbors.size() == 0) {
            return Optional.empty();
        }

        int random = ThreadLocalRandom.current().nextInt(0, neighbors.size());

        return Optional.of(neighbors.get(random));
    }

    private List<Node> getNeighborsFor(Node[][] maze, Node node) {
        List<Node> neighbors = new ArrayList<>();

        int x = node.x;
        int y = node.y;

        if (indexInBound(maze, x, y - 1)) {
            neighbors.add(new Node(x, y - 1));
        }

        if (indexInBound(maze, x - 1, y)) {
            neighbors.add(new Node(x - 1, y));
        }

        return neighbors;
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
