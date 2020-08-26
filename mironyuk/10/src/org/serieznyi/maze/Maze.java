package org.serieznyi.maze;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Maze {
    private final int[][] schema;
    private Point finish;
    private Point start;

    Maze(int[][] schema) {

        this.schema = schema;

        init();
    }

    public int[][] getSchema() {
        return schema;
    }

    public Point getStart() {
        return this.start;
    }

    public Point getFinish() {
        return this.finish;
    }

    public void init() {
        initStart();

        initFinish();
    }

    private void initFinish() {
        for (int i = schema.length / 2; i < schema.length; i++) {
            for (int i1 = schema[i].length / 2; i1 < schema[i].length; i1++) {
                if (schema[i][i1] == 1) {
                    finish = new Point(i, i1);
                    return;
                }
            }
        }

        throw new RuntimeException("Не смог выбрать старт лабиринта");
    }

    private void initStart() {
        for (int i = 0; i < schema.length / 2; i++) {
            for (int i1 = 0; i1 < schema[i].length / 2; i1++) {
                if (schema[i][i1] == 1) {
                    start = new Point(i, i1);
                    return;
                }
            }
        }

        throw new RuntimeException("Не смог выбрать финиш лабиринта");
    }

    private boolean indexInBound(int x, int y){
        return schema != null && x >= 0 && x < schema.length && y >= 0 && y < schema[x].length;
    }

    public boolean isPath(Point point) {
        return indexInBound(point.x, point.y) && schema[point.x][point.x] == 1;
    }

    public List<Point> getNeighborsFor(Point point) {
        List<Point> neighbors = Arrays.asList(
                new Point(point.x, point.y - 1),
                new Point(point.x, point.y + 1),
                new Point(point.x - 1, point.y),
                new Point(point.x + 1, point.y)
        );

        return neighbors.stream().filter(p -> indexInBound(p.x, p.y)).collect(Collectors.toList());
    }
}