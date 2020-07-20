package org.serieznyi.FightOfWizards.logging;

public interface Handler {
    void success(String message);
    void warning(String message);
    void dangerous(String message);
    void info(String message);
    void debug(String message);
}
