package org.serieznyi.maze;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static final int MIN_PLAYERS_COUNT = 1;
    public static final int MAX_PLAYERS_COUNT = 2;
    public static final int MAZE_SIZE = 10;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MazeGenerator generator = new MazeGenerator();

        Maze maze = generator.generate(MAZE_SIZE);

        drawMaze(maze);

        List<Player> players = makePlayers(maze);

        ExecutorService service = Executors.newFixedThreadPool(4);

        List<Future<Player>> results = new ArrayList<>();

        for (Player player : players) {
            final Future<Player> task = service.submit(() -> {
                while (!player.step()) {}

                return player;
            });

            results.add(task);
        }

        for (Future<Player> result : results) {
            Player player = result.get();

            System.out.println(player.getName() + " нашел выход из лабиринта");
        }

        service.shutdown();
    }

    private static List<Player> makePlayers(Maze maze) {
        List<Player> players = new ArrayList<>();

        int count = ThreadLocalRandom.current().nextInt(MIN_PLAYERS_COUNT, MAX_PLAYERS_COUNT);

        for (int i = 0; i < count; i++) {
            Player player = new Player(
            "Player " + (i + 1),
                    maze,
                    maze.getStart(),
                    maze.getFinish()
            );

            players.add(player);
        }

        return players;
    }

    private static void drawMaze(Maze maze) {
        int[][] schema = maze.getSchema();

        for (int[] ints : schema) {
            for (int anInt : ints) {
                System.out.print(anInt == 1 ? " " : "*");
            }

            System.out.println();
        }
    }
}
