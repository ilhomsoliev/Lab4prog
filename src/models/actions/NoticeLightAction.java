package models.actions;

import interfaces.Observer;

public class NoticeLightAction implements Observer {
    private final String characterName;

    public NoticeLightAction(String characterName) {
        this.characterName = characterName;
    }

    @Override
    public String observe() {
        return characterName + " увидела узкую полоску света";
    }
}