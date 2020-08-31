package org.serieznyi.maze;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {
    static ThreadLocalRandom random = ThreadLocalRandom.current();

    public static final int MIN_PLAYERS_COUNT = 3;
    public static final int MAZE_SIZE = 30;

    public static void main(String[] args) throws InterruptedException {
        MazeGenerator generator = new MazeGenerator();

        Maze maze = generator.generate(MAZE_SIZE);

        drawMaze(maze);

        System.out.print("\nФиниш находится в " + maze.getFinish() + "\n\n");

        List<Player> players = makePlayers(maze);

        for (Player player : players) {
            System.out.println(player.getName() + " в позиции " + player.getPosition());
        }

        System.out.println();

        ExecutorService service = Executors.newCachedThreadPool();

        for (Player player : players) {
            service.submit(() -> {
                long start = System.currentTimeMillis();

                while (!player.step()) {}

                System.out.printf(
                        "%s нашел выход из лабиринта за %s количество шагов и %s милисекунд\n",
                        player.getName(),
                        player.getPath().size(),
                        System.currentTimeMillis() - start
                );

                return player;
            });
        }

        service.shutdown();

        service.awaitTermination(3, TimeUnit.SECONDS);

        service.shutdownNow();

        Optional<Player> min = players.stream().min(Comparator.comparing(player -> player.getPath().size()));

        System.out.println();

        min.ifPresent(p -> System.out.printf("%s сделал меньше всех шагов: %s\n", p.getName(), p.getPath().size()));
    }

    private static List<Player> makePlayers(Maze maze) {
        List<Player> players = new ArrayList<>();

        List<String> names = Arrays.asList(
                "Красный",
                "Синий",
                "Черный",
                "Голубой",
                "Зеленый",
                "Оранжевый",
                "Фиолетовый",
                "Коричневый",
                "Белый",
                "Пурпурный",
                "Серый"
        );


        for (String name : names.subList(0, random.nextInt(MIN_PLAYERS_COUNT, names.size()))) {
            Player player = new Player(
                    name,
                    maze,
                    maze.randomPointAroundFinish(),
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
