package maze_racing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MazeGenerator {
    static int WALL = 0;
    static int CELL = 1;
    static int VISITED = 2;


    static void randomGenerating(boolean[][] mazeBoolean) {
        int[][] mazeInt = new int[mazeBoolean.length][mazeBoolean[0].length];

        for (int i = 0; i < mazeBoolean.length; i++) {
            for (int j = 0; j < mazeBoolean[0].length; j++) {
                if ((i % 2 != 0 && j % 2 != 0) && //если ячейка нечетная по x и y,
                        (i < mazeBoolean.length - 1 && j < mazeBoolean[0].length - 1))   //и при этом находится в пределах стен лабиринта
                    mazeInt[i][j] = CELL;       //то это КЛЕТКА
                else mazeInt[i][j] = WALL;           //в остальных случаях это СТЕНА.
            }
        }

        Point currentCell = new Point(1, 1);
        mazeInt[currentCell.getY()][currentCell.getX()] = VISITED;
        Point neighbourCell;

        List<Point> visitedPoints = new ArrayList<>();

        while (unvisitedCount(mazeInt) > 0) {
            Point[] neighbours = getNeighbours(mazeInt, currentCell);
            if (neighbours.length != 0) { //если у клетки есть непосещенные соседи
                visitedPoints.add(currentCell);
                int randNumOfNeighbours = new Random().nextInt(neighbours.length);
                neighbourCell = neighbours[randNumOfNeighbours]; //выбираем случайного соседа
                removeWall(currentCell, neighbourCell, mazeInt);//убираем стену между текущей и сосендней точками
                currentCell = neighbourCell; //делаем соседнюю точку текущей и отмечаем ее посещенной
                mazeInt[currentCell.getY()][currentCell.getX()] = VISITED;
            } else if (visitedPoints.size() > 0) { //если нет соседей, возвращаемся на предыдущую точку
                currentCell = visitedPoints.get(visitedPoints.size() - 1);
                visitedPoints.remove(currentCell);
            } else { //если нет соседей и точек в стеке, но не все точки посещены, выбираем случайную из непосещенных
                Point[] cellStringUnvisited = getUnvisitedCells(mazeInt);
                int randNumOfUnvisitedCell = new Random().nextInt(cellStringUnvisited.length);
                currentCell = cellStringUnvisited[randNumOfUnvisitedCell];
            }
        }

        for (int i = 0; i < mazeInt.length; i++) {
            for (int j = 0; j < mazeInt[0].length; j++) {
                mazeBoolean[i][j] = mazeInt[i][j] != WALL;
            }
        }
    }

    static Point[] getNeighbours(int[][] maze, Point c) {
        int i;
        int x = c.getX();
        int y = c.getY();
        Point up = new Point(x, y - 2);
        Point rt = new Point(x + 2, y);
        Point dw = new Point(x, y + 2);
        Point lt = new Point(x - 2, y);
        Point[] d = {dw, rt, up, lt};
        int size = 0;

        Point[] cells = new Point[4];

        for (i = 0; i < 4; i++) { //для каждого направления
            if (0 < d[i].getX() && d[i].getX() < maze[0].length - 1 &&
                    0 < d[i].getY() && d[i].getY() < maze.length - 1) { //если не выходит за границы лабиринта
                int mazeCellCurrent = maze[d[i].getY()][d[i].getX()];
                if (mazeCellCurrent != WALL && mazeCellCurrent != VISITED) { //не стена и не посещена
                    cells[size] = d[i]; //записать в массив;
                    size++;
                }
            }
        }
        return Arrays.copyOf(cells, size);
    }

    static void removeWall(Point firstPoint, Point secondPoint, int[][] maze) {
        int xDiff = secondPoint.getX() - firstPoint.getX();
        int yDiff = secondPoint.getY() - firstPoint.getY();

        Point target = new Point(firstPoint.getX() + xDiff / 2, firstPoint.getY() + yDiff / 2); // Стена

        maze[firstPoint.getY()][firstPoint.getX()] = VISITED;
        maze[target.getY()][target.getX()] = VISITED;
        maze[secondPoint.getY()][secondPoint.getX()] = VISITED;
    }

    static Point[] getUnvisitedCells(int[][] maze) {
        Point[] cells = new Point[maze.length * maze[0].length];
        int size = 0;

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if ((maze[i][j] != WALL) && (maze[i][j] != VISITED)) {
                    cells[size] = new Point(j, i);
                    size++;
                }
            }
        }
        return Arrays.copyOf(cells, size);
    }

    static int unvisitedCount(int[][] maze) { //used
        int count = 0;
        for (int[] ints : maze)
            for (int j = 0; j < maze[0].length; j++)
                if (ints[j] != WALL && ints[j] != VISITED) count++;
        return count;
    }
}
