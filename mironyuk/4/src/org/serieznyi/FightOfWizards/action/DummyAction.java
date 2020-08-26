package org.serieznyi.FightOfWizards.action;

import org.serieznyi.FightOfWizards.action.result.Result;
import org.serieznyi.FightOfWizards.character.Character;

final public class DummyAction implements Action {
    private Character initiator;
    private Result result;

    private DummyAction()
    {
        super();
    }

    public DummyAction(Character initiator, Result result) {
        this.initiator = initiator;
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    @Override
    public Character getInitiator() {
        return initiator;
    }
}
