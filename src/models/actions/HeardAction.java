package models.actions;

import interfaces.Action;

public class HeardAction implements Action {

    private final String whoHeard;
    private final String whatWhoHeard;

    public HeardAction(String whoHeard, String whatWhoHeard) {
        this.whoHeard = whoHeard;
        this.whatWhoHeard = whatWhoHeard;
    }


    @Override
    public String perform() {
        return whoHeard + " услышали, как " + whatWhoHeard;
    }
}
