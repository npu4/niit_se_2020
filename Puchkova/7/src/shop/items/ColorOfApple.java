package shop.items;

public enum ColorOfApple{
    GREEN("зелёное"),
    YELLOW("жёлтое"),
    RED("красное");

    private final String color;

    ColorOfApple(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}