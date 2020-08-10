package org.serieznyi.FightOfWizards.action.result;

final public class CausingDamageResult extends Result {
    private final int takenDamage;
    private final int originalDamageValue;
    private final int newCharacterHealth;


    public CausingDamageResult(boolean successful, int takenDamage, int originalDamageValue, int newCharacterHealth) {
        super(successful);
        this.takenDamage = takenDamage;
        this.originalDamageValue = originalDamageValue;
        this.newCharacterHealth = newCharacterHealth;
    }

    public int getTakenDamage() {
        return takenDamage;
    }

    public int getOriginalDamageValue() {
        return originalDamageValue;
    }

    public int getNewCharacterHealth() {
        return newCharacterHealth;
    }
}
