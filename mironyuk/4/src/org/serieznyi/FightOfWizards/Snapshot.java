package org.serieznyi.FightOfWizards;

import org.serieznyi.FightOfWizards.action.Action;
import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.serialization.serializer.annotation.Serialize;

import java.util.List;
import java.util.Map;

@Serialize
public class Snapshot {
    private Map<Integer, Character> characters;
    private List<Action> actions;

    Snapshot() {}

    Snapshot(List<Action> actions, Map<Integer, Character> characters) {

        this.actions = actions;
        this.characters = characters;
    }

    public Map<Integer, Character> getCharacters() {
        return characters;
    }

    public List<Action> getActions() {
        return actions;
    }
}
