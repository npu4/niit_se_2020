package exceptionInterface.elements;

import exceptionInterface.exceptions.ReadOnlyException;

public interface Clickable {
    void click() throws ReadOnlyException;
}
