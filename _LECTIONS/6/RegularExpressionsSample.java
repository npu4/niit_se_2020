import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionsSample {


    public static void main(String[] args) {


        String textWithNumbers = "Номер книги 45 в библиотеке";

        Pattern p = Pattern.compile("([0-9]+)");

        final Matcher matcher = p.matcher(textWithNumbers);
        if (matcher.find()) {
            System.out.println("Нашли число " + matcher.group(1));
        }


        String textWithNumbers2= "Номер книги 87 в библиотеке";


        final Matcher matcher2 = p.matcher(textWithNumbers2);
        if (matcher2.find()) {
            System.out.println("Нашли число " + matcher2.group(1));
        }


    }
}
