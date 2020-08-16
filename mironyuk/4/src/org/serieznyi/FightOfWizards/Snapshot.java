package org.serieznyi.FightOfWizards;

import org.serieznyi.FightOfWizards.action.Action;
import org.serieznyi.serialization.serializer.annotation.Serialize;

import java.util.List;

@Serialize
public class Snapshot {
    private List<Action> actions;

    Snapshot() {}

    Snapshot(List<Action> actions) {

        this.actions = actions;
    }
}
