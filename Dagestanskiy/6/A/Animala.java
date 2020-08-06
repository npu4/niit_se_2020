
class Animal {
    String typeAnimal;
    String name;

    public Animal(String typeAnimal, String name) {
        this.typeAnimal = typeAnimal;
        this.name = name;
    }

    public String getTypeAnimal() {
        return typeAnimal;
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "typeAnimal='" + typeAnimal + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
