package interfaces.elements;

import interfaces.exceptions.ReadOnlyException;

public interface Clickable {
    void click();

    default void isElementActive(boolean isOn) throws ReadOnlyException {
        if (!isOn) {
            throw new ReadOnlyException();
        }
    }
}
