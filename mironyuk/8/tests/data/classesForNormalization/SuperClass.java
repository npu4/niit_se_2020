package data.classesForNormalization;

public class SuperClass {
    private String fieldOfSuperClass = "superClassField";

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SuperClass that = (SuperClass) o;

        return fieldOfSuperClass.equals(that.fieldOfSuperClass);
    }

    @Override
    public int hashCode() {
        return fieldOfSuperClass.hashCode();
    }
}
