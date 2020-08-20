package maze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Participant player1 = new Participant("John", new Maze());
        Participant player2 = new Participant("Helen", new Maze());
        Participant player3 = new Participant("Tom", new Maze());

        List<Participant> players = new ArrayList<>(Arrays.asList(player1, player2, player3));

        Thread t1 = new Thread(() -> move(player1));
        Thread t2 = new Thread(() -> move(player2));
        Thread t3 = new Thread(() -> move(player3));

        List<Thread> threads = new ArrayList<>(Arrays.asList(t1, t2, t3));
        threads.forEach(Thread::start);

        t1.join();
        t2.join();
        t3.join();
        
        int minSteps = players
                .stream()
                .min(Comparator.comparingInt(Participant::getStepCounter))
                .get().getStepCounter();
        players
                .stream()
                .filter(participant -> participant.getStepCounter() == minSteps)
                .forEach(participant -> System.out.printf("\n%s сделал наименьшее количество шагов - %d",
                        participant.getName(), participant.getStepCounter()));

    }

    public static void move(Participant participant) {
        long time = System.currentTimeMillis();
        while (!participant.isFinished()) {
            participant.move();
        }
        System.out.println(participant.getLog());
        time = System.currentTimeMillis() - time;
        System.out.printf("%s финишировал, сделав %d шагов за %dмс\n",
                participant.getName(), participant.getStepCounter(), time);
    }
}
