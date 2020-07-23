public class BoxSample {


    static class Box <T> {
        private T item;

        public Box(T item) {
            this.item = item;
        }

        public T getItem() {
            return item;
        }
    }

    public static void main(String[] args) {
        Box<String> stringBox = new Box<>("76L");
        Box<Number> numberBox = new Box<>(24);


        final String stringValue = stringBox.getItem();

        final Number item = numberBox.getItem();
        System.out.println(item.intValue() + 2);


    }
}
