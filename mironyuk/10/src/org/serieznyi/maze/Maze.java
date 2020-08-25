package org.serieznyi.maze;

class Maze {
    private final int[][] schema;
    private Point finish;
    private Point start;

    Maze(int[][] schema) {

        this.schema = schema;

        resetStartAndFinish();
    }

    public int[][] getSchema() {
        return schema;
    }

    public Point getStart() {
        return this.finish;
    }

    public Point getFinish() {
        return this.start;
    }

    public void resetStartAndFinish() {
        for (int i = 0; i < schema.length / 2; i++) {
            for (int i1 = 0; i1 < schema[i].length / 2; i1++) {
                if (schema[i][i1] == 1) {
                    start = new Point(i, i1);
                    return;
                }
            }
        }

        for (int i = schema.length / 2; i < schema.length; i++) {
            for (int i1 = schema[i].length / 2; i1 < schema[i].length; i1++) {
                if (schema[i][i1] == 1) {
                    start = new Point(i, i1);
                    return;
                }
            }
        }

        throw new RuntimeException("Не смог выбрать финиш лабиринта");
    }
}