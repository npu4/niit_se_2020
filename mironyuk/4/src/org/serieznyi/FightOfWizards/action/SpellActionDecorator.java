package org.serieznyi.FightOfWizards.action;

import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.character.Wizard;
import org.serieznyi.FightOfWizards.character.wizard.Spell;

public class SpellActionDecorator implements Action {
    private Spell spell;
    private Wizard wizard;
    private Action originalAction;

    private SpellActionDecorator()
    {
        super();
    }

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
