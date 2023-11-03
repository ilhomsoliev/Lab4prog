package models.actions;

import interfaces.Action;

public class GetIntoSilently implements Action {
    @Override
    public String perform() {
        return "на цыпочках вошла туда";
    }
}
