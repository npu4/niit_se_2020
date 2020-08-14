package org.mironyuk.lecture;

import java.util.Set;

final public class Student {
    final String name;
    final Set<Lecture> lectures;

    public Student(String name, Set<Lecture> lectures) {
        this.name = name;
        this.lectures = lectures;
    }

    public String getName() {
        return name;
    }

    public Set<Lecture> getLectures() {
        return lectures;
    }

    @Override
    public String toString() {
        return name + ": " + lectures;
    }
}
