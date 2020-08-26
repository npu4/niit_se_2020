package org.serieznyi.FightOfWizards.action.result;

final public class MessageResult extends Result {
    private MessageResult() {

    }

    public MessageResult(String message) {
        super(true, message);
    }
}
