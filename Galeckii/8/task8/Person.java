package task8;

import task8.annotations.XmlIgnore;
import task8.annotations.XmlName;
import task8.annotations.XmlTypeName;

@XmlTypeName(className = "Человек")
public class Person {
    @XmlName(fieldName = "Имя")
    String name;
    @XmlName(fieldName = "Фамилия")
    String lastName;
    @XmlIgnore
    int age;

    public Person() {
    }

    public Person(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }
}
