package maze_racing;

import java.util.Random;

import static maze_racing.MazeGenerator.randomGenerating;

public class Maze {
    static final boolean WALL = false;
    boolean[][] maze;
    Point start;
    Point finish;

    Maze(int height, int width) {
        maze = new boolean[height][width];
        randomGenerating(maze);
        setStart();
        setFinish();
    }

    public Point getStart() {
        return start;
    }

    public Point getFinish() {
        return finish;
    }

    void setStart() {
        Point start = new Point(0, 0);
        while (maze[start.getY()][start.getX()] == WALL || start.equals(this.finish)) {
            start = new Point(new Random().nextInt(maze[0].length), new Random().nextInt(maze.length));
        }
        this.start = start;
    }

    void setFinish() {
        Point finish = new Point(0, 0);
        while (maze[finish.getY()][finish.getX()] == WALL || finish.equals(this.start)) {
            finish = new Point(new Random().nextInt(maze[0].length), new Random().nextInt(maze.length));
        }
        this.finish = finish;
    }

    public boolean[][] getMaze() {
        return maze;
    }

    void print() {
        for (boolean[] booleans : maze) {
            for (int j = 0; j < maze[0].length; j++) {
                if (booleans[j]) {
                    System.out.print(" ");
                } else {
                    System.out.print("X");
                }
            }
            System.out.println();
        }
        System.out.println("Старт: " + getStart().toString());
        System.out.println("Финиш: " + getFinish().toString());
        System.out.println();
    }
}
