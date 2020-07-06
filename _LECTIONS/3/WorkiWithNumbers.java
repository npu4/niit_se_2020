import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class WorkiWithNumbers {

    public static void main(String[] args) {


        int someValue = Integer.MAX_VALUE;
        long longValue = someValue;

        longValue = longValue + 1;


        System.out.println("Max int value = " + someValue);
        System.out.println(someValue + 1);
        System.out.println(longValue );


        long someLong = 42;
        int anotherIntValue = (int) someLong;


    }
}
