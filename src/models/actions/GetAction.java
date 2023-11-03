package models.actions;

import enums.Item;
import interfaces.Action;

public class GetAction implements Action {
    private final String characterName;
    private final Item item;

    public GetAction(String characterName, Item item) {
        this.characterName = characterName;
        this.item = item;
    }

    @Override
    public String perform() {
        return characterName + " взяла " + item.name;
    }
}