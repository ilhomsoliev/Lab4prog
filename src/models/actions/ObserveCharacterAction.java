package models.actions;

import interfaces.Observer;

public class ObserveCharacterAction implements Observer {
    private final String characterName;

    public ObserveCharacterAction(String characterName) {
        this.characterName = characterName;
    }
    @Override
    public String observe() {
        return "Там сидела " + characterName;
    }
}
