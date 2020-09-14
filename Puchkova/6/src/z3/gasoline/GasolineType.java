package z3.gasoline;

enum GasolineType {
    DISEL_FUEL("ДТ"),
    OCTAIN_NUMBER_92("АИ-92"),
    OCTAIN_NUMBER_95("АИ-95"),
    OCTAIN_NUMBER_98("АИ-98");

    private final String title;

    GasolineType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}