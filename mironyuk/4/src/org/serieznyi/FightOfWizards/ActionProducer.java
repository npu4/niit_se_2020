package org.serieznyi.FightOfWizards;

import org.serieznyi.FightOfWizards.action.*;
import org.serieznyi.FightOfWizards.action.result.CausingDamageResult;
import org.serieznyi.FightOfWizards.action.result.HealingResult;
import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.logging.Logger;

import java.util.Set;

final public class ActionProducer {
    static final Logger LOGGER = Logger.create();

    public void produce(Action action)
    {
        if (action instanceof CausingDamageAction) {
            produceCausingDamageAction((CausingDamageAction) action);
        } else if (action instanceof HealingAction) {
            produceHealingAction((HealingAction) action);
        } else if (action instanceof DummyAction) {
            produceDummyAction((DummyAction) action);
        } else if (action instanceof SpellActionDecorator) {
            produceSpellAction((SpellActionDecorator) action);
        } else {
            throw new RuntimeException("Неизвестное действие");
        }
    }

    private void produceSpellAction(SpellActionDecorator action) {
        LOGGER.readSpell(action.getInitiator(), action.getSpell());

        produce(action.getRealAction());
    }

    public void produceCausingDamageAction(CausingDamageAction action)
    {
        Set<Character> targets = action.getTargets();
        Character initiator = action.getInitiator();

        LOGGER.characterAttack(initiator, targets);

        for (Character target : targets) {
            CausingDamageResult result = (CausingDamageResult) target.reactOnAction(action);

            if (result.isSuccessful()) {
                LOGGER.takeDamageTo(initiator, target, result.getTakenDamage());
            }
        }
    }

    public void produceDummyAction(DummyAction action)
    {
        LOGGER.debug(action.getResult().getMessage());
    }

    public void produceHealingAction(HealingAction action)
    {
        Set<Character> targets = action.getTargets();
        Character initiator = action.getInitiator();

        LOGGER.characterAttack(initiator, targets);

        for (Character target : targets) {
            HealingResult result = (HealingResult) target.reactOnAction(action);

            if (result.isSuccessful()) {
                LOGGER.healing(initiator, result.getRestoredHealth(), result.getNewHealthValue());
            }
        }
    }
}
