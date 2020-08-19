package forSerialize;


import annotations.XmlIgnore;
import annotations.XmlName;
import annotations.XmlTypeName;

@XmlTypeName(typeName = "Человек")
public class Person {
    @XmlName(fieldName = "Имя")
    String firsName;
    @XmlName(fieldName = "Возраст")
    double age;
    @XmlIgnore
    String password;

    public Person() {
    }

    public Person(String firsName, double age, String password) {
        this.firsName = firsName;
        this.age = age;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firsName='" + firsName + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}
