import java.util.Arrays;
import java.util.List;

public class MainTuple {
    public static void main(String[] args) {
        Pair<String, List<String>> nameCatFavoriteFood= new Pair<>("Пушок", Arrays.asList("Мясо","Рыба "));
        System.out.println("У кота "+ nameCatFavoriteFood.getFirst()+ " любимые блюда :"+
                nameCatFavoriteFood.getSecond().toString());

        Triple<String, Number, List<String>> lastNameAgeToPhoneNumber =
                new Triple<>("Иванов", 25, Arrays.asList("+7 910 9012343", "+7 831 2200655"));

        System.out.println(lastNameAgeToPhoneNumber.getFirst()+" возраст "+lastNameAgeToPhoneNumber.getSecond()+
                " лет. Телефоны: "+lastNameAgeToPhoneNumber.getThird().toString() );
    }
}
