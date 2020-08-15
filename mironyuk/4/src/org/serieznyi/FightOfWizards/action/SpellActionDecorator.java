package org.serieznyi.FightOfWizards.action;

import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.character.Wizard;
import org.serieznyi.FightOfWizards.character.wizard.Spell;

public class SpellActionDecorator implements Action {
    private final Spell spell;
    private final Wizard wizard;
    private final Action originalAction;

    public SpellActionDecorator(Spell spell, Wizard wizard, Action originalAction) {
        this.spell = spell;
        this.wizard = wizard;
        this.originalAction = originalAction;
    }

    @Override
    public Character getInitiator() {
        return wizard;
    }

    public Spell getSpell() {
        return spell;
    }

    public Action getRealAction() {
        return originalAction;
    }
}
