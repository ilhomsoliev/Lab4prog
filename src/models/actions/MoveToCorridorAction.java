package models.actions;

import enums.Place;
import interfaces.Movable;

public class MoveToCorridorAction implements Movable {
    @Override
    public String moveTo(Place place) {
        return place == Place.CORRIDOR ? "вышла в коридор" : "";
    }
}