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

        public Direction turn() {
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

        Objects.requireNonNull(mazeFinish);
        this.mazeFinish = mazeFinish;
    }

    public String getName() {
        return name;
    }

    public boolean step() {

        do {
            Point newStep = new Point(currentPosition.x + direction.x, currentPosition.y + direction.y);

            if (maze.isPath(newStep)) {
                path.add(newStep);

                currentPosition = newStep;

                System.out.println(currentPosition + ": " + mazeFinish);

                return currentPosition.equals(mazeFinish);
            }

            direction = direction.turn();
        } while (true);
    }
}