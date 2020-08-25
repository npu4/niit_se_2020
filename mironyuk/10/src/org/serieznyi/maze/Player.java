package org.serieznyi.maze;

import java.util.ArrayList;
import java.util.List;

class Player
{
    private final String name;
    private final Maze maze;
    private final Point currentPosition;
    private final Point mazeEnd;
    private final List<Point> path = new ArrayList<>();

    Player(String name, Maze maze, Point currentPosition, Point mazeFinish) {
        this.name = name;
        this.maze = maze;
        this.currentPosition = currentPosition;
        this.mazeEnd = mazeFinish;
    }

    public String getName() {
        return name;
    }

    public boolean step() {
        return false;
    }
}