package gasStation;

import java.util.*;

public class gasStationMain {

    public static void main(String[] args) {
        ArrayList<GasStation> stations = new ArrayList<>();
        stations.add(new GasStation<>("Пушкина,10", FuelEnum.ДЕВЯНОСТО_ВТОРОЙ, 42.5));
        stations.add(new GasStation<>("Пушкина,15", FuelEnum.ДЕВЯНОСТО_ПЯТЫЙ, 46.1));
        stations.add(new GasStation<>("Пушкина,20", FuelEnum.ДЕВЯНОСТО_ВОСЬМОЙ, 48.2));
        stations.add(new GasStation<>("Пушкина,25", FuelEnum.ДИЗЕЛЬ, 46.3));
        stations.add(new GasStation<>("Пушкина,30", FuelEnum.ДЕВЯНОСТО_ВТОРОЙ, 41.6));
        stations.add(new GasStation<>("Пушкина,35", FuelEnum.ДИЗЕЛЬ, 44.5));
        System.out.println(findBestPrice(stations, FuelEnum.ДЕВЯНОСТО_ВТОРОЙ));
    }


    static String findBestPrice(ArrayList<GasStation> stations, Enum type) {
        ArrayList<GasStation> typeStation = new ArrayList<>();
        for (GasStation gasStation : stations) {
            if (gasStation.getType().equals(type))
                typeStation.add(gasStation);
        }
        typeStation.sort(Comparator.comparing(GasStation::getPrice));
        return (String) typeStation.get(0).getAddress();
    }
}
