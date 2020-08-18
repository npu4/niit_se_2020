package com;

public enum LectureName {

    matan("Математический анализ"),phil("Философия"), eng("Английский язык"),hist("История"),phys("Физкультура");
    private final String name;
    LectureName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "LectureName{" +
                "name='" + name + '\'' +
                '}';
    }
}
