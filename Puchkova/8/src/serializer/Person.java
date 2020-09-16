package serializer;

import serializer.annotations.XmlIgnore;
import serializer.annotations.XmlName;
import serializer.annotations.XmlTypeName;

@XmlTypeName(typeName = "Человек")
public final class Person {
    @XmlName(fieldName = "Имя")
    public String firstName;

    @XmlName(fieldName = "Возраст")
    public int age;

    @XmlIgnore
    public String password;

    public Person(){
    }

    public Person(String firstName, int age, String password) {
        this.firstName = firstName;
        this.age = age;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}
