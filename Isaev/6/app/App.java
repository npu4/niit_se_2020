package app;

public class App<String,Double> {
    private String name;
    private Double numberOfRatings;
    private Double averageRating;

    public App(String name, Double numberOfRatings, Double averageRating) {
        this.name = name;
        this.numberOfRatings = numberOfRatings;
        this.averageRating = averageRating;
    }

    public String getName() {
        return name;
    }

    public double getNumberOfRatings() {
        return (double)numberOfRatings;
    }

    public double getAverageRating() {
        return (double)averageRating;
    }

    @Override
    public java.lang.String toString() {
        return "App{" +
                "name=" + name +
                ", numberOfRatings=" + numberOfRatings +
                ", averageRating=" + averageRating +
                '}';
    }
}
