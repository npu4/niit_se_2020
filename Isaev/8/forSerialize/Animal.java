package forSerialize;


import annotations.XmlName;
import annotations.XmlTypeName;

@XmlTypeName(typeName = "Животное")
public class Animal {
    @XmlName(fieldName = "Кличка")
    String nickname;
    @XmlName(fieldName = "Любимая еда")
    String favouriteFood;
    @XmlName(fieldName = "Тип животного")
    String type;

    public Animal() {
    }

    public Animal(String nickname, String favouriteFood, String type) {
        this.nickname = nickname;
        this.favouriteFood = favouriteFood;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + nickname + '\'' +
                ", favouriteFood='" + favouriteFood + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
