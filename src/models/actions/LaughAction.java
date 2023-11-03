package models.actions;

import enums.Mood;
import interfaces.Action;
import models.charackter.Character;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LaughAction implements Action {

    private Character whoLaughed;
    private List<Mood> newMoods;

    public LaughAction(Character whoLaughed) {
        this.whoLaughed = whoLaughed;
        this.newMoods = new ArrayList<>();
    }

    public LaughAction(Character whoLaughed, Mood... newMoods) {
        this.whoLaughed = whoLaughed;
        this.newMoods = Arrays.asList(newMoods);
    }

    @Override
    public String perform() {
        if (newMoods.size() == 0) {
            return "засмеялась " + whoLaughed.getName();
        } else {
            final String[] answer = {"на этот раз она смеялась не "};
            List<Mood> oldMoods = whoLaughed.getMoods();
            oldMoods.forEach(mood ->
                    answer[0] = answer[0] + mood.getName() + " "
            );
            answer[0] = answer[0] + ", a ";
            newMoods.forEach(mood ->
                    answer[0] = answer[0] + mood.getName() + " "
            );
            return answer[0];
        }
    }
}
