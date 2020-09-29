package maze_racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Racing {
    static final int MIN_NUM_OF_RACERS = 3;
    static final int MAX_NUM_OF_RACERS = 10;
    static String[] names = {"Амалия", "Астрид", "Барбара", "Ингрид", "Клаудия", "Линда", "Марта", "Мия", "Эмма", "Эрика"};
    static int countName = 0;

    public static void racing(Maze maze) throws ExecutionException, InterruptedException {
        List<Future<Racer>> racers = new ArrayList<>();
        int numOfRacers = new Random().nextInt(MAX_NUM_OF_RACERS - MIN_NUM_OF_RACERS + 1) + MIN_NUM_OF_RACERS;

        ExecutorService service = Executors.newFixedThreadPool(numOfRacers, r -> {
            final Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        });

        for(int i = 0; i < numOfRacers; i++){
            final Future<Racer> racerFuture = service.submit(() -> {
                long timeThreadStart = System.currentTimeMillis();
                Racer racer = new Racer(names[countName++], maze);
                while (! racer.step());
                System.out.println("Игрок " + racer.getName() + " прошел лабиринт за " + racer.numOfSteps() + " шагов " +
                        "за " + (System.currentTimeMillis() - timeThreadStart) + " миллисекунды");
                return racer;
            });

            racers.add(racerFuture);
        }

        Racer racerMinNumOfSteps = racers.get(0).get();

        for(Future<Racer> racer : racers){
            if(racer.get().numOfSteps() < racerMinNumOfSteps.numOfSteps()){
                racerMinNumOfSteps = racer.get();
            }
        }
        System.out.println("Наименьшее чило шагов сделала участница с именем " + racerMinNumOfSteps.getName() +
                ", она получает особый приз!");
    }
}
