package models.actions;

import interfaces.Action;

public class SilenceAction  implements Action {
    private final String characterName;

    public SilenceAction(String characterName) {
        this.characterName = characterName;
    }
    @Override
    public String perform() {
        return "Но " + characterName + " не отвечала";
    }
}