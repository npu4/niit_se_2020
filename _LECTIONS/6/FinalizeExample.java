
public class FinalizeExample {


    static class PersonFinalize {
        @Override
        protected void finalize() throws Throwable {
            System.out.println("Я собрался!");
        }
    }

    public static void main(String[] args) {


        PersonFinalize o = new PersonFinalize();
        System.gc();
        System.out.println("End");
    }
}
