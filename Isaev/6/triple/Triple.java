package triple;

import java.util.Objects;

public class Triple<String, List>{

    private String name;
    private java.util.List<Integer> ageToPhoneNumber;

    public Triple(String name, java.util.List<Integer> ageToPhoneNumber) throws Exception {
        this.name = name;
        this.ageToPhoneNumber = ageToPhoneNumber;
        if (ageToPhoneNumber.size()!=2){
            throw  new Exception("Please input age and work experience");
        }
    }

    public String getFirst(){
        return name;

    }

    public Integer getSecond(){
        return (Integer) ageToPhoneNumber.get(0);

    }

    public Integer getThird(){
        return (Integer) ageToPhoneNumber.get(1);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triple<?, ?> triple = (Triple<?, ?>) o;
        return Objects.equals(name, triple.name) &&
                Objects.equals(ageToPhoneNumber, triple.ageToPhoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ageToPhoneNumber);
    }
}
