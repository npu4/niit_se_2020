package app;

import triple.Triple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class appMain {
    public static void main(String[] args) {
        List<Triple<String,Double,Double>> apps = new ArrayList<>();
        apps.add(new Triple<>("AppOne",37.,4.2));
        apps.add(new Triple<>("AppTwo",5.,4.6));
        apps.add(new Triple<>("AppThree",58.,3.1));
        apps.add(new Triple<>("AppFour",30.,2.4));
        apps.add(new Triple<>("AppFive",10.,1.));
        List<Triple<String,Double,Double>> sortedApps = getSortedNumberOfRatings(apps);
        for(Triple<String, Double, Double> app : sortedApps){
            System.out.println(app.toString());
        }
        System.out.println(getBestRaitingApp(apps));
        System.out.println(getWorseRaitingApp(apps));

    }

   static List<Triple<String,Double,Double>> getSortedNumberOfRatings(List<Triple<String,Double,Double>> apps){
        apps.sort(Comparator.comparing(Triple::getSecond));
        return apps;
    }

    static List<Triple<String,Double,Double>> getSortedAverageRating(List<Triple<String,Double,Double>> apps){
        apps.sort(Comparator.comparing(Triple::getThird));
        return apps;
    }

    static Triple<String,Double,Double> getBestRaitingApp(List<Triple<String,Double,Double>> apps) {
       return getSortedAverageRating(apps).get(apps.size()-1);
    }

    static Triple<String,Double,Double> getWorseRaitingApp(List<Triple<String,Double,Double>> apps) {
        return getSortedAverageRating(apps).get(0);
    }

}


