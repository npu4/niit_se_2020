public enum  GasolineType {
    DT("ДТ"), AI92("АИ-92"), AI95("АИ-95"), AI98("АИ-98");
    private final String name;

    GasolineType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "GasolineType{" +
                "name='" + name + '\'' +
                '}';
    }
}
