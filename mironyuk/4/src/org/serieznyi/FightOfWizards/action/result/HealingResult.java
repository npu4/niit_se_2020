package org.serieznyi.FightOfWizards.action.result;

final public class HealingResult extends Result {
    private final int restoredHealth;
    private final int newHealthValue;

    public HealingResult(boolean successful, int restoredHealth, int newHealthValue) {
        super(successful);

        this.restoredHealth = restoredHealth;
        this.newHealthValue = newHealthValue;
    }

    public int getRestoredHealth() {
        return restoredHealth;
    }

    public int getNewHealthValue() {
        return newHealthValue;
    }
}
