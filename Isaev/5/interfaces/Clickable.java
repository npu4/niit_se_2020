package interfaces;

import exceptions.ElementIsOffException;

public interface Clickable {

    void click() throws ElementIsOffException;

}
