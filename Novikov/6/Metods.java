import java.util.List;
import java.util.Random;

public class Metods {

    private static Random random = new Random();

    public static void feedAnimals(List<Pair<Animal, String>> list) {
        int perem=random.nextInt(list.size());
        for (Pair<Animal, String> target : list){
            System.out.println(target.getFirst().getName()+" с радостью съедает "+ target.getSecond());
        }
        System.out.println("Счастливое животное " + list.get(perem).getFirst().getName()+" получило двойную порцию "+ list.get(perem).getSecond());
    }



    public static void  findBestPrice(List<Triple<String,Petrol,Double>> list,Petrol type ){
        double min=Double.MAX_VALUE;
        String place="";
        for (Triple<String, Petrol, Double> gasStation : list){
            if(gasStation.getSecond()==type&&gasStation.getFired()<min){
                min=gasStation.getFired();
                place=gasStation.getFirst();
            }
        }
        System.out.printf("Самый дешевый бензин на станции " + place + " по цене " + min+ "\n");
    }

    public static void rating(List<Triple<String,Double,Double>> list){
        String[] name = new String[list.size()];
        double[] rate = new double[list.size()];
        int i=0;
        for (Triple<String,Double,Double> app : list){
            rate[i]=app.getSecond();
            name[i]=app.getFirst();
            i++;
        }

        for(i=0;i<list.size()-1;i++){
            for(int j=0; j<list.size()-1; j++){
                if (rate[j] > rate[j + 1]){
                   double temp = rate[j];
                   String str=name[j];
                   rate[j] = rate[j + 1];
                   name[j] = name[j + 1];
                   rate[j + 1] = temp;
                   name[j + 1] = str;
                }
            }
        }
        for(i=0;i<list.size();i++){
            System.out.println(name[i] +" количество оценок "+ rate[i]);
        }
    }

    public static void badRating(List<Triple<String,Double,Double>> list) {
        double min = Double.MAX_VALUE;
        String place = "";
        for (Triple<String, Double, Double> app : list) {
            if (app.getFired() < min) {
                min = app.getFired();
                place = app.getFirst();
            }
        }
        System.out.printf("Самое худшее приложение " + place + " с рйтингом " + min + "\n");
    }

    public static void bestRating(List<Triple<String,Double,Double>> list) {
        double max = Double.MIN_VALUE;
        String place = "";
        for (Triple<String, Double, Double> app : list) {
            if (app.getFired() > max) {
                max = app.getFired();
                place = app.getFirst();
            }
        }
        System.out.printf("Самое лучшее приложение " + place + " с рйтингом " + max + "\n");
    }

}
