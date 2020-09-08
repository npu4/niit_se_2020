package exceptionInterface.elements;

import exceptionInterface.exceptions.ELementsOverlapException;

public interface ButtonClickCallback {

    void onButtonClick() throws ELementsOverlapException;
}