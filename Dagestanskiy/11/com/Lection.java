package com;

import java.time.LocalDate;

public class Lection {
    private String name;
    private LocalDate date;

    public Lection(String name, LocalDate date) {
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
        return "Lection{" +
                "name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
