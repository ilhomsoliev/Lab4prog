package models.actions;

import interfaces.Action;

public class DescribeHeadCharacterAction implements Action {

    @Override
    public String perform() {
        return "лоси у нее на голове были совсем другие";
    }
}
