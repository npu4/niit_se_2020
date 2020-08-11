package org.mironyuk.lecture;

import java.time.LocalDate;

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
}
