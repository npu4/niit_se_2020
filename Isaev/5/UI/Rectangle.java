package UI;

public class Rectangle {

    private static int DEFAULT_WIDTH = 100;
    private static int DEFAULT_HIGH = 100;
    private int width;
    private int high;

    public Rectangle() {

    }

    public Rectangle(int width, int high) {
        this.width = width;
        this.high = high;
    }

    public static int getDefaultWidth() {
        return DEFAULT_WIDTH;
    }

    public static int getDefaultHigh() {
        return DEFAULT_HIGH;
    }

    public int getWidth() {
        return width;
    }

    public int getHigh() {
        return high;
    }
}


