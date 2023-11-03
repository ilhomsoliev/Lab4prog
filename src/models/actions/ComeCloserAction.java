package models.actions;

import interfaces.Action;

public class ComeCloserAction implements Action {
    @Override
    public String perform() {
        return "пробивающуюся сквозь полуоткрытую дверь";
    }
}
