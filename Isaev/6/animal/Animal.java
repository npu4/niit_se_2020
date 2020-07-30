package animal;

public class Animal {
    private String name;
    private String type;

    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public java.lang.String toString() {
        return java.lang.String.format( "%s" ,name);
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
