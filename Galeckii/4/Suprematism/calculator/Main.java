package calculator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Figure[] figures = new Figure[]
                {new Circle(), new Square(), new IsoscelesTriangle(), new Circle(), new Square()};

        Arrays.stream(figures).forEach(System.out::println);
    }
}
