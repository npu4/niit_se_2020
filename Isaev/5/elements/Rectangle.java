package elements;

public class Rectangle {

    private int leftCoornX;
    private int leftCoornY;
    private int height;
    private int length;
    private String name;
    private boolean isTurnedON;

    public Rectangle(int leftCoornX, int leftCoornY, String name) {
        this.leftCoornX = leftCoornX;
        this.leftCoornY = leftCoornY;
        this.height = height;
        this.length = length;
        this.name = name;
    }

    public Rectangle(int leftCoornX, int leftCoornY, int height, int length, boolean isTurnedON) {
        this.leftCoornX = leftCoornX;
        this.leftCoornY = leftCoornY;
        this.height = height;
        this.length = length;
        this.isTurnedON = isTurnedON;
    }

    public Rectangle(int leftCoornX, int leftCoornY, String name, boolean isTurnedON) {
        this.leftCoornX = leftCoornX;
        this.leftCoornY = leftCoornY;
        this.height = 8;
        this.length = 16;
        this.name = name;
        this.isTurnedON = isTurnedON;
    }

    public int getLeftCoornX() {
        return leftCoornX;
    }

    public void setLeftCoornX(int leftCoornX) {
        this.leftCoornX = leftCoornX;
    }

    public int getLeftCoornY() {
        return leftCoornY;
    }

    public void setLeftCoornY(int leftCoornY) {
        this.leftCoornY = leftCoornY;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTurnedON() {
        return isTurnedON;
    }

    public void setTurnedON(boolean turnedON) {
        isTurnedON = turnedON;
    }
}


