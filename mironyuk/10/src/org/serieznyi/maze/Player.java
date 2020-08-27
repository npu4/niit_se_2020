package org.serieznyi.maze;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Player
{
    enum Direction {
        EAST(1, 0),
        NORTH(0, 1),
        WEST(-1, 0),
        SOUTH(0, -1);

        private final int x;

        private final int y;
        Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Direction turnRight() {
            switch (this) {
                case EAST:
                    return SOUTH;
                case SOUTH:
                    return WEST;
                case WEST:
                    return NORTH;
                case NORTH:
                    return EAST;
            }

            throw new RuntimeException("Wrong direction");
        }

        public Direction turnLeft() {
            switch (this) {
                case EAST:
                    return NORTH;
                case NORTH:
                    return WEST;
                case WEST:
                    return SOUTH;
                case SOUTH:
                    return EAST;
            }

            throw new RuntimeException("Wrong direction");
        }
    }

    private Direction direction = Direction.EAST;
    private final String name;
    private final Maze maze;
    private Point currentPosition;
    private final Point mazeFinish;
    private final List<Point> path = new ArrayList<>();

    Player(String name, Maze maze, Point currentPosition, Point mazeFinish) {
        this.name = name;
        this.maze = maze;

        Objects.requireNonNull(currentPosition);
        this.currentPosition = currentPosition;

        path.add(currentPosition);

        Objects.requireNonNull(mazeFinish);
        this.mazeFinish = mazeFinish;
    }

    public List<Point> getPath() {
        return path;
    }

    public String getName() {
        return name;
    }

    public Point getPosition() {
        return currentPosition;
    }

    public boolean step() {

        if (!turnRightAndStepForward()) {
                while (!stepForward()) {
                    turnLeft();

//                    System.out.println(name + " : " + currentPosition);
                }
            }

        return currentPosition.equals(mazeFinish);
    }

    private boolean turnRightAndStepForward() {
        turnRight();

        Point newPosition = new Point(currentPosition.x + direction.x, currentPosition.y + direction.y);

        if (maze.isFreeSpace(newPosition)) {
            changeCurrentPositionOn(newPosition);
            return true;
        }

        turnLeft();

        return false;
    }

    private void changeCurrentPositionOn(Point newPosition) {
        currentPosition = newPosition;
        path.add(newPosition);
    }

    private boolean stepForward() {
        Point newPosition = new Point(currentPosition.x + direction.x, currentPosition.y + direction.y);

        if (maze.isFreeSpace(newPosition)) {
            changeCurrentPositionOn(newPosition);
            return true;
        }

        return false;
    }

    private void turnLeft() {
        direction = direction.turnLeft();
    }

    private void turnRight() {
        direction = direction.turnRight();
    }
}