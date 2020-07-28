import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainLists {
    public static void main(String[] args) {
        List<Triple<String,GasolineType,Double>> listOfGasStations = new ArrayList<>();
        listOfGasStations.add(new Triple<>("Н.Новгород, Гагарина 1", GasolineType.DT,45d));
        listOfGasStations.add(new Triple<>("Н.Новгород, Бекетова 13", GasolineType.DT,46d));
        listOfGasStations.add(new Triple<>("Н.Новгород, Усилова 5", GasolineType.DT,42d));
        listOfGasStations.add(new Triple<>("Н.Новгород, Деловая 6", GasolineType.AI92,47d));
        listOfGasStations.add(new Triple<>("Н.Новгород, Радионова 12", GasolineType.AI92,44d));
        listOfGasStations.add(new Triple<>("Н.Новгород, Бусыгина 1", GasolineType.AI95,45d));


        List<Triple<String,Double,Double>> listOfPhoneApp = new ArrayList<>();
        listOfPhoneApp.add(new Triple<>("Opera", 20d, 4d));
        listOfPhoneApp.add(new Triple<>("Ghrome", 300d, 4.5d));
        listOfPhoneApp.add(new Triple<>("Gismeteo", 50d, 3.6d));
        listOfPhoneApp.add(new Triple<>("Birthday Remainder", 50d, 4.2d));
        listOfPhoneApp.add(new Triple<>("Календарь", 45d, 3.8d));
        listOfPhoneApp.add(new Triple<>("Калькулятор", 65d, 4.1d));

        MainLists m =new MainLists();
        m.findBestPrice(listOfGasStations, GasolineType.DT);
        m.findBestPrice(listOfGasStations, GasolineType.AI92);
        m.findBestPrice(listOfGasStations, GasolineType.AI98);

        m.printListOfPhoneApp(listOfPhoneApp,"\nСписок приложений на телефон:");
        listOfPhoneApp.sort(new CompareListOfPhoneApp());
        m.printListOfPhoneApp(listOfPhoneApp,"\nСписок приложений на телефон, " +
                "отсортированный по количеству оценок:");
        m.findBestApp(listOfPhoneApp);
        m.findWorsttApp(listOfPhoneApp);



    }

    public void findBestPrice(List<Triple<String,GasolineType,Double>> list, GasolineType type) {
        int indexGasStation = -1;
        double minPrice = 0d;
//        String gasStationAddres = "";
        for (int i = 0; i <list.size() ; i++) {
            if (indexGasStation==-1) {
                if (list.get(i).getSecond().equals(type)) {
                    indexGasStation = i;
                    minPrice = list.get(i).getThird();
                }
            } else {
                if (list.get(i).getSecond().equals(type)) {
                    if(list.get(i).getThird()<minPrice){
                        minPrice = list.get(i).getThird();
                        indexGasStation = i;
                    }
                }
            }
        }
        if (indexGasStation>=0){
            System.out.println("На бензоколонке по адресу: "+list.get(indexGasStation).getFirst()+
                    " цена на бензин марки "+list.get(indexGasStation).getSecond().getName()+": "+
                    list.get(indexGasStation).getThird()+" - самая низкая.");
        } else {
            System.out.println("На бензоколонках бензина марки "+ type.getName() +" нет.");
        }
    }

    public void printListOfPhoneApp(List<Triple<String,Double,Double>> list,String title) {
        System.out.println(title);
        for (Triple<String, Double, Double> stringDoubleDoubleTriple : list) {
            System.out.println("Название приложения: " + stringDoubleDoubleTriple.getFirst() +
                    ", количество оценок: " + stringDoubleDoubleTriple.getSecond() +
                    ", средний рейтинг " + stringDoubleDoubleTriple.getThird() + ".");

        }
    }

    public static class CompareListOfPhoneApp implements Comparator<Triple<String,Double,Double>> {
        @Override
        public int compare(Triple<String, Double, Double> o1, Triple<String, Double, Double> o2) {
            return o1.getSecond().compareTo(o2.getSecond());
        }
    }

    public void findBestApp(List<Triple<String,Double,Double>> list){
        Double bestRating = list.get(0).getThird();
        int index = 0;
        for (int i = 0; i <list.size() ; i++) {
            if (list.get(i).getThird() > bestRating){
                bestRating = list.get(i).getThird();
                index = i;
            }
        }
        System.out.println("Приложние: "+list.get(index).getFirst()+" имеет лучший рейтинг- "+
                list.get(index).getThird()+".");
    }

    public void findWorsttApp(List<Triple<String,Double,Double>> list){
        Double worstRating =list.get(0).getThird();
        int index = 0;
        for (int i = 0; i <list.size() ; i++) {
            if (list.get(i).getThird() < worstRating){
                worstRating = list.get(i).getThird();
                index = i;
            }
        }
        System.out.println("Приложние: "+list.get(index).getFirst()+" имеет худший рейтинг - "+
                list.get(index).getThird()+".");
    }




}
