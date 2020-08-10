package org.serieznyi.FightOfWizards.action.result;

final public class MissResult extends Result {
    public static MissResult INSTANCE = new MissResult(false);

    private MissResult(boolean successful) {
        super(successful);
    }
}
