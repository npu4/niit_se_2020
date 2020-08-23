package lectures;


import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Student {

    private String name;
    private Set<Lection> lections;
    private static final String[] NAMES = {"Вася", "Петя", "Никита", "Олег", "Даша", "Лена", "Катя", "Алина", "Руслан", "Вероника"};

    public Student() {
        this.name = NAMES[new Random().nextInt(NAMES.length)];
        this.lections = getLectionsToSet(5 + new Random().nextInt(10));
    }

    private Set<Lection> getLectionsToSet(int numberOfLections) {
        Set<Lection> tmpLection = new HashSet<>() {
        };
        for (int i = 0; i < numberOfLections; i++) {
            tmpLection.add(new Lection());
        }

        return tmpLection;

    }

    public String getName() {
        return name;
    }

    public Set<Lection> getLections() {
        return lections;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name;
    }
}
