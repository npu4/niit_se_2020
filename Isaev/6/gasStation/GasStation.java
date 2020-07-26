package gasStation;

public class GasStation<String,Enum,Double> {
    private String address;
    private Enum type;
    private Double price;

    public GasStation(String address, Enum type, Double price) {
        this.address = address;
        this.type = type;
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public Enum getType() {
        return type;
    }

    public double getPrice() {
        return (double)price;
    }
}
