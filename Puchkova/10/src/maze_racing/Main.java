package maze_racing;

import java.util.concurrent.*;

import static maze_racing.Racing.racing;

public class Main {
    static final int HEIGHT = 21;
    static final int WIDTH = 31;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Maze maze = new Maze(HEIGHT, WIDTH);
        maze.print();

        racing(maze);
    }
}
