package org.serieznyi.FightOfWizards.actionProducer;

import org.serieznyi.FightOfWizards.Scene;
import org.serieznyi.FightOfWizards.action.Action;
import org.serieznyi.FightOfWizards.character.Character;

import java.util.Set;

public interface ObjectsProducer {
    Action nextAction(Scene scene);

    Set<Character> getCharacters(Scene scene, int count);
}
