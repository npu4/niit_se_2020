package org.serieznyi.FightOfWizards.action.result;

public abstract class Result {
    private final boolean successful;
    private final String message;

    Result() {
        message = "";
        successful = true;
    }

    Result(boolean successful)
    {
        this.successful = successful;
        this.message = "";
    }

    Result(boolean successful, String message)
    {
        this.successful = successful;
        this.message = message;
    }

    public boolean isSuccessful()
    {
        return successful;
    }

    public String getMessage() {
        return message;
    }
}
