public class Figure {
    private int x;
    private int y;

    public Figure(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Figure() {
        this.x = 0;
        this.y = 0;
    }
    public int getQuadrant() {
        if (x > 0  & y > 0) return 1;
        if (x > 0  & y < 0) return 2;
        if (x < 0  & y < 0) return 3;
        if (x < 0  & y >0)  return 4;
        return 0;
    }
    public String getStrSquare(){
        return "";
    }

    @Override
    public String toString() {
        return "Figure{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
class Circle extends Figure {
    private double radius;
    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }
    public Circle(int radius) {
        this.radius = radius;
    }
    public double square(){
        return 3.1415926*radius*radius;
    }
    public String getStrSquare( ){
        return "Circle - площадь: " + Double.toString(square());
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
class Square extends Figure {
    private double side;

    public Square(int x, int y, double side) {
        super(x, y);
        this.side = side;
    }
    public Square(double side) {
        this.side = side;
    }
    public double square(){
        return side*side;
    }
    public String getStrSquare( ){
        return "Square - площадь: " + Double.toString(square());
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                '}';
    }
}
class IsosscelesTriangle extends Figure {
    private double height;
    private double base;

    public IsosscelesTriangle(int x, int y, double height, double base) {
        super(x, y);
        this.height = height;
        this.base = base;
    }

    public IsosscelesTriangle(double height, double base) {
        this.height = height;
        this.base = base;
    }
    public double square(){
        return height*base/2;
    }
    public String getStrSquare( ){
        return "IsoscelesTriangle - площадь: " + Double.toString(square());
    }

    @Override
    public String toString() {
        return "IsosscelesTriangle{" +
                "height=" + height +
                ", base=" + base +
                '}';
    }
}