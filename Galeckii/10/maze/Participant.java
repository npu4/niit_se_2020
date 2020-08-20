package maze;

import java.util.*;

public class Participant {
    private String name;
    private Maze maze;
    private Position currentPos;
    private Position previousPos;
    private Stack<Position> visitedPositions = new Stack<>();
    private Stack<Position> deadEndPositions = new Stack<>();
    private boolean finished = false;
    private int stepCounter = 0;
    private List<Position> log = new ArrayList<>();

    public Participant(String name, Maze maze) {
        this.name = name;
        this.maze = maze;
        currentPos = maze.getStart();
        visitedPositions.push(new Position(currentPos.getX(), currentPos.getY() - 1));
        log.add(new Position(maze.getStart()));
    }

    public void move() {
        stepCounter++;

        previousPos = new Position(currentPos.getX(), currentPos.getY());

        if (!makeStep()) {
            deadEndPositions.push(currentPos);
            currentPos = visitedPositions.pop();
            return;
        }
        visitedPositions.push(previousPos);

        if (currentPos.equals(maze.getFinish())) {
            finished = true;
        }

        log.add(new Position(currentPos));

        try {
            Thread.sleep(new Random().nextInt(20)+10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean makeStep() {
        List<Integer> taskNumbers = new ArrayList<>(Arrays.asList(1,2,3,4));
        Collections.shuffle(taskNumbers);

        for (Integer taskNumber : taskNumbers) {

            switch (taskNumber) {
                case 1:
                    if (checkLeft(currentPos)) {
                        currentPos.setX(currentPos.getX() - 1);
                        return true;
                    }

                case 2:
                    if (checkRight(currentPos)) {
                        currentPos.setX(currentPos.getX() + 1);
                        return true;
                    }

                case 3:
                    if (checkUp(currentPos)) {
                        currentPos.setY(currentPos.getY() - 1);
                        return true;
                    }

                case 4:
                    if (checkDown(currentPos)) {
                        currentPos.setY(currentPos.getY() + 1);
                        return true;
                    }
            }
        }
        return false;
    }

    private boolean checkLeft(Position position) {
        Position comparePosition = new Position(position.getX() - 1, position.getY());
        return !comparePosition.equals(visitedPositions.peek()) && isAvailable(comparePosition)
                && !isPositionLeadToDeadEnd(comparePosition);
    }

    private boolean checkRight(Position position) {
        Position comparePosition = new Position(position.getX() + 1, position.getY());
        return !comparePosition.equals(visitedPositions.peek()) && isAvailable(comparePosition)
                && !isPositionLeadToDeadEnd(comparePosition);
    }

    private boolean checkDown(Position position) {
        Position comparePosition = new Position(position.getX(), position.getY() + 1);
        return !comparePosition.equals(visitedPositions.peek()) && isAvailable(comparePosition)
                && !isPositionLeadToDeadEnd(comparePosition);
    }

    private boolean checkUp(Position position) {
        Position comparePosition = new Position(position.getX(), position.getY() - 1);
        return !comparePosition.equals(visitedPositions.peek()) && isAvailable(comparePosition)
                && !isPositionLeadToDeadEnd(comparePosition);
    }

    private boolean isAvailable(Position position) {
        try {
            return maze.getMaze()[position.getY()][position.getX()] == 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    private boolean isPositionLeadToDeadEnd(Position position) {
        try {
            return position.equals(deadEndPositions.peek());
        } catch (EmptyStackException e) {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public boolean isFinished() {
        return finished;
    }

    public int getStepCounter() {
        return stepCounter;
    }

    public List<Position> getLog() {
        return log;
    }
}
