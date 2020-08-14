package org.mironyuk.lecture;

import java.time.LocalDate;
import java.util.Objects;

final public class Lecture {
    final String name;
    final LocalDate date;

    public Lecture(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
    return name + "(" + date + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lecture lecture = (Lecture) o;
        return name.equals(lecture.name) &&
                date.equals(lecture.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, date);
    }
}
