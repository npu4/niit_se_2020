package maze_racing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Racer {
    private final String name;
    Maze maze;
    Point currentPosition;
    Point finish;
    private final List<Point> route = new ArrayList<>();

    public Racer(String name, Maze maze) {
        this.name = name;
        this.maze = maze;
        this.currentPosition = maze.getStart();
        this.finish = maze.getFinish();
        route.add(currentPosition);
    }

    public String getName() {
        return name;
    }

    public int numOfSteps(){
        return route.size();
    }

    boolean step(){
        if(currentPosition.equals(finish)){
            return true;
        }
        else{
            Point[] steps = getPossibleSteps(currentPosition);
            currentPosition = steps[new Random().nextInt(steps.length)];
            route.add(currentPosition);
            return false;
        }
    }

    Point[] getPossibleSteps(Point currentPoint) {
        boolean[][] maze = this.maze.getMaze();
        int x = currentPoint.getX();
        int y = currentPoint.getY();
        Point up = new Point(x, y - 1);
        Point rt = new Point(x + 1, y);
        Point dw = new Point(x, y + 1);
        Point lt = new Point(x - 1, y);
        Point[] d = {dw, rt, up, lt};

        int size = 0;
        Point[] steps = new Point[4];

        for (int i = 0; i < 4; i++) { //для каждого направления
            if (0 < d[i].getX() && d[i].getX() < maze[0].length - 1 &&
                    0 < d[i].getY() && d[i].getY() < maze.length - 1) { //если не выходит за границы лабиринта
                boolean mazeCellCurrent = maze[d[i].getY()][d[i].getX()];
                if (mazeCellCurrent) { //не стена и не посещена
                    steps[size] = d[i]; //записать в массив;
                    size++;
                }
            }
        }
        return Arrays.copyOf(steps, size);
    }
}
