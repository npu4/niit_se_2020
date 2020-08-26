package org.serieznyi.FightOfWizards.action.result;

final public class NoneResult extends Result {
    public static NoneResult INSTANCE = new NoneResult(false);

    private NoneResult() {}

    private NoneResult(boolean successful) {
        super(successful);
    }
}
