package streamingLectures;


import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Student {

    String name;
    Set<Lection> lections;
    String[] names = {"Вася", "Петя", "Никита", "Олег", "Даша", "Лена", "Катя", "Алина", "Руслан", "Вероника"};

    public Student() {
        this.name = names[new Random().nextInt(names.length)];
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
