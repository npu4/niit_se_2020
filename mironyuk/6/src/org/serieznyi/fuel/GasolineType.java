package org.serieznyi.fuel;

public enum GasolineType {
    OCTANE_RATE_92,
    OCTANE_RATE_95,
    OCTANE_RATE_98,
    DIESEL_FUEL;

    @Override
    public String toString() {
        switch (this) {
            case DIESEL_FUEL: return "ДТ";
            case OCTANE_RATE_92: return "A-92";
            case OCTANE_RATE_95: return "A-95";
            case OCTANE_RATE_98: return "A-98";
            default: throw new IllegalArgumentException();
        }
    }
}
