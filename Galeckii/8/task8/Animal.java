package task8;

import task8.annotations.XmlName;
import task8.annotations.XmlTypeName;

@XmlTypeName(className = "Животное")
public class Animal {
    @XmlName(fieldName = "Кличка")
    String name;
    @XmlName(fieldName = "Цвет")
    String color;
    @XmlName(fieldName = "Вес")
    int weight;

    public Animal() {
    }

    public Animal(String name, String color, int weight) {
        this.name = name;
        this.color = color;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
