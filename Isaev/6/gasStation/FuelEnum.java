package gasStation;

enum FuelEnum {
    ДЕВЯНОСТО_ВТОРОЙ("АИ-92"),
    ДЕВЯНОСТО_ПЯТЫЙ("АИ-95"),
    ДЕВЯНОСТО_ВОСЬМОЙ("АИ-98"),
    ДИЗЕЛЬ("ДТ");

    private String title;

    FuelEnum(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
