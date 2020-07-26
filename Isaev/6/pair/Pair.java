package pair;

import java.util.Objects;

public class Pair<String,Integer> {

    private String name;
    private Integer age;

    public Pair(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    
    public String getFirst(){
        return name;

    }

    public Integer getSecond(){
        return age;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(name, pair.name) &&
                Objects.equals(age, pair.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
