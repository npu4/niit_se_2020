package data.classesForNormalization;

import org.serieznyi.serialization.serializer.annotation.Serialize;

@Serialize()
public class ClassWithoutDefaultConstructor {
    public String fieldOne = "one";

    public String fieldTwo = "two";

    public ClassWithoutDefaultConstructor(String fieldOne, String fieldTwo) {
        this.fieldOne = fieldOne;
        this.fieldTwo = fieldTwo;
    }
}
