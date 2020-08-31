package org.serieznyi.maze;

import java.util.concurrent.ThreadLocalRandom;

class Maze {
    private final int[][] schema;
    private Point finish;
    ThreadLocalRandom random = ThreadLocalRandom.current();

    Maze(int[][] schema) {

        this.schema = schema;

        init();
    }

    public int[][] getSchema() {
        return schema;
    }

    public Point getFinish() {
        return this.finish;
    }

    public void init() {
        initFinish();
    }

    /**
     * Финиш всегда в правой нижней части лабиринта
     */
    private void initFinish() {
        for (int x = schema.length / 2; x < schema.length; x++) {
            for (int y = schema[x].length / 2; y < schema[x].length; y++) {
                if (schema[x][y] == 1) {
                    finish = new Point(x, y);
                    return;
                }
            }
        }

        throw new RuntimeException("Не смог выбрать старт лабиринта");
    }

    private boolean indexInBound(int x, int y){
        return schema != null && x >= 0 && x < schema.length && y >= 0 && y < schema[x].length;
    }

    public boolean isFreeSpace(Point point) {
        return indexInBound(point.x, point.y) && schema[point.x][point.y] == 1;
    }

    public boolean isCorrectRandomPoint(Point point) {
        int halfX = (schema.length - 1) / 2;
        int halfY = (schema[halfX].length - 1) / 2;

        return !(point.x > halfX && point.y > halfY) && isFreeSpace(point);
    }

    public Point randomPointAroundFinish() {
        Point randomPoint;

        do {
            randomPoint = new Point(
                    random.nextInt(0, schema.length),
                    random.nextInt(0, schema[0].length)
            );
        } while (!isCorrectRandomPoint(randomPoint));

        return randomPoint;
    }
}