public class FigureMain {
    public static void main(String[] args) {
        Figure f1 = new Circle(2,4,3);
        Figure f2 = new Square(-3,10,5);
        Figure f3 = new IsosscelesTriangle(-4, -3, 10, 4);
        Figure f4 = new Circle(1,-6,2);
        Figure f5 = new Square(3,10,4);
        Figure[] figures = {f1, f2, f3, f4, f5};
        for (int i = 0; i <5 ; i++) {
            System.out.println("Квадрант " + figures[i].getQuadrant()+ ", " + figures[i].getStrSquare());

        }
    }
}
