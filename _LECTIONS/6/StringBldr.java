public class StringBldr {


    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Начало");
        sb.append(" xnj-nj \n");
        sb.append(" 123 ");
        sb.append(" <> ");

        System.out.println(sb.toString());
    }
}
