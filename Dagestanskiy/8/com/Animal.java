import java.util.Objects;

@XmlTypeName("Животное")
public class Animal {
    @XmlName("Вид животного")
    String typeAnimal;
    @XmlName("Кличка")
    String name;
    @XmlIgnore("")
    Integer age;
    String favoriteFood;
    @XmlName("Прививки")
    Boolean vaccinations;

    public Animal() {
    }

    public Animal(String typeAnimal, String name, Integer age, String favoriteFood, Boolean vaccinations) {
        this.typeAnimal = typeAnimal;
        this.name = name;
        this.age = age;
        this.favoriteFood = favoriteFood;
        this.vaccinations = vaccinations;
    }

    public String getTypeAnimal() {
        return typeAnimal;
    }

    public void setTypeAnimal(String typeAnimal) {
        this.typeAnimal = typeAnimal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public Boolean getVaccinations() {
        return vaccinations;
    }

    public void setVaccinations(Boolean vaccinations) {
        this.vaccinations = vaccinations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(typeAnimal, animal.typeAnimal) &&
                Objects.equals(name, animal.name) &&
                Objects.equals(age, animal.age) &&
                Objects.equals(favoriteFood, animal.favoriteFood) &&
                Objects.equals(vaccinations, animal.vaccinations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeAnimal, name, age, favoriteFood, vaccinations);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "\n typeAnimal='" + typeAnimal + '\'' +
                "\n name='" + name + '\'' +
                "\n age=" + age +
                "\n favoriteFood='" + favoriteFood + '\'' +
                "\n vaccinations=" + vaccinations +
                "\n}";
    }
}

