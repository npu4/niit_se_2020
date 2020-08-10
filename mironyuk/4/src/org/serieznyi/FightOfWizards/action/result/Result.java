package org.serieznyi.FightOfWizards.action.result;

public abstract class Result {
    private final boolean successful;

    Result(boolean successful)
    {
        this.successful = successful;
    }

    public boolean isSuccessful()
    {
        return successful;
    }
}
