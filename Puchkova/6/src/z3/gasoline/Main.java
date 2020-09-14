package z3.gasoline;

import z1.Triple;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Triple<String,GasolineType,Double>> listOfGasStations = new ArrayList<>();

        listOfGasStations.add(new Triple<>("Московское шоссе, 213Б", GasolineType.DISEL_FUEL, 46.4));
        listOfGasStations.add(new Triple<>("Московское шоссе, 213Б", GasolineType.OCTAIN_NUMBER_92, 43.1));
        listOfGasStations.add(new Triple<>("Московское шоссе, 213Б", GasolineType.OCTAIN_NUMBER_95, 47.2));
        listOfGasStations.add(new Triple<>("Московское шоссе, 213Б", GasolineType.OCTAIN_NUMBER_98, 46.));

        listOfGasStations.add(new Triple<>("ул. Заводская, 4А", GasolineType.DISEL_FUEL, 45.99));
        listOfGasStations.add(new Triple<>("ул. Заводская, 4А", GasolineType.OCTAIN_NUMBER_92, 42.49));
        listOfGasStations.add(new Triple<>("ул. Заводская, 4А", GasolineType.OCTAIN_NUMBER_95, 46.09));

        listOfGasStations.add(new Triple<>("ул. Салганская, 24А", GasolineType.DISEL_FUEL, 45.79));
        listOfGasStations.add(new Triple<>("ул. Салганская, 24А", GasolineType.OCTAIN_NUMBER_92, 42.89));
        listOfGasStations.add(new Triple<>("ул. Салганская, 24А", GasolineType.OCTAIN_NUMBER_95, 45.99));
        listOfGasStations.add(new Triple<>("ул. Салганская, 24А", GasolineType.OCTAIN_NUMBER_98, 49.99));

        findBestPrice(listOfGasStations, GasolineType.DISEL_FUEL);
        findBestPrice(listOfGasStations, GasolineType.OCTAIN_NUMBER_92);
        findBestPrice(listOfGasStations, GasolineType.OCTAIN_NUMBER_95);
        findBestPrice(listOfGasStations, GasolineType.OCTAIN_NUMBER_98);
    }

    static void findBestPrice(List<Triple<String, GasolineType, Double>> list, GasolineType type){
        String address = " ";
        Double bestPrice = Double.MAX_VALUE;
        for (Triple<String, GasolineType, Double> stringGasolineTypeDoubleTriple : list) {
            if (stringGasolineTypeDoubleTriple.getSecond() == type && stringGasolineTypeDoubleTriple.getThird() < bestPrice) {
                bestPrice = stringGasolineTypeDoubleTriple.getThird();
                address = stringGasolineTypeDoubleTriple.getFirst();
            }
        }
        System.out.println("Самая маленькая цена на бензин " + type.getTitle() + " находится по адресу " + address);
    }
}