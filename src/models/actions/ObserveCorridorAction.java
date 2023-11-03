package models.actions;

import interfaces.Observer;

public class ObserveCorridorAction implements Observer {
    @Override
    public String observe() {
        return "Там никого не было";
    }
}