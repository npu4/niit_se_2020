package data.classesForNormalization;

import org.serieznyi.serialization.serializer.annotation.Serialize;

@Serialize
public class ClassWithSuperClass extends SuperClass {
    Integer classField = 42;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ClassWithSuperClass that = (ClassWithSuperClass) o;

        return classField.equals(that.classField);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + classField.hashCode();
        return result;
    }
}
