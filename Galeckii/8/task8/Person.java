package task8;

import task8.annotations.XmlIgnore;
import task8.annotations.XmlName;
import task8.annotations.XmlTypeName;

@XmlTypeName(className = "Человек")
public class Person {
    @XmlName(fieldName = "Имя")
    String name;
    @XmlIgnore
    String lastName;
    @XmlName(fieldName = "Возраст")
    int age;

    public Person() {
    }

    public Person(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
