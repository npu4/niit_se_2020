package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class appMain {
    public static void main(String[] args) {
        ArrayList<App> apps = new ArrayList<>();
        apps.add(new App("AppOne",37.,4.2));
        apps.add(new App("AppTwo",5.,4.6));
        apps.add(new App("AppThree",58.,3.1));
        apps.add(new App("AppFour",30.,2.4));
        apps.add(new App("AppFive",10.,1.));
        ArrayList<App> sortedApps = getSortedNumberOfRatings(apps);
        for(App app : sortedApps){
            System.out.println(app.toString());
        }
        System.out.println(getBestRaitingApp(apps));
        System.out.println(getWorseRaitingApp(apps));

    }

   static ArrayList<App> getSortedNumberOfRatings(ArrayList<App> apps){
        ArrayList<App> sortedApps = apps;
        sortedApps.sort(Comparator.comparing(App::getNumberOfRatings));
        return sortedApps;
    }

    static ArrayList<App> getSortedAverageRating(ArrayList<App> apps){
        ArrayList<App> sortedApps = apps;
        sortedApps.sort(Comparator.comparing(App::getAverageRating));
        return sortedApps;
    }

    static App getBestRaitingApp(ArrayList<App> apps) {
       ArrayList<App> sortedApp = getSortedAverageRating(apps);
       return sortedApp.get(sortedApp.size()-1);
    }

    static App getWorseRaitingApp(ArrayList<App> apps) {
        ArrayList<App> sortedApp = getSortedAverageRating(apps);
        return sortedApp.get(0);
    }

}


