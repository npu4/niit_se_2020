package org.serieznyi.maze;

public class Main {
    public static void main(String[] args) {
        MazeGenerator generator = new MazeGenerator();

        int[][] maze = generator.generate(10, 10);

        drawMaze(maze);
    }

    private static void drawMaze(int[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int i1 = 0; i1 < maze[i].length; i1++) {
                System.out.print(maze[i][i1] == 1 ? " " : "*");
            }

            System.out.println();
        }
    }
}
