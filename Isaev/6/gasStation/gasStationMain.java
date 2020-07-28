package gasStation;

import triple.Triple;

import java.util.*;

public class gasStationMain {

    public static void main(String[] args) {
        List<Triple<String,FuelEnum,Double>> stations = new ArrayList<>();
        stations.add(new Triple<>("Пушкина,10", FuelEnum.ДЕВЯНОСТО_ВТОРОЙ, 42.5));
        stations.add(new Triple<>("Пушкина,15", FuelEnum.ДЕВЯНОСТО_ПЯТЫЙ, 46.1));
        stations.add(new Triple<>("Пушкина,20", FuelEnum.ДЕВЯНОСТО_ВОСЬМОЙ, 48.2));
        stations.add(new Triple<>("Пушкина,25", FuelEnum.ДИЗЕЛЬ, 46.3));
        stations.add(new Triple<>("Пушкина,30", FuelEnum.ДЕВЯНОСТО_ВТОРОЙ, 41.6));
        stations.add(new Triple<>("Пушкина,35", FuelEnum.ДИЗЕЛЬ, 44.5));
        System.out.println(findBestPrice(stations, FuelEnum.ДЕВЯНОСТО_ВТОРОЙ));
    }


    static String findBestPrice(List<Triple<String,FuelEnum,Double>> stations, FuelEnum fuel) {
        List<Triple<String,FuelEnum,Double>> typeStation = new ArrayList<>();
        for (Triple<String,FuelEnum,Double> gasStation : stations) {
            if (gasStation.getSecond().equals(fuel))
                typeStation.add(gasStation);
        }
        typeStation.sort(Comparator.comparing(Triple::getThird));
        return typeStation.get(0).getFirst();
    }
}
