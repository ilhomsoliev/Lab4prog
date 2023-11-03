package models.scene;

import enums.Speed;
import exceptions.checked.CharacterNotExistsException;
import exceptions.checked.NotEnoughCharactersException;
import exceptions.unchecked.SceneCanNotStayException;
import interfaces.Tellable;
import models.charackter.Character;

import java.util.*;

public class Scene {
    private Tellable story;
    private Boolean isSpinning;
    private Speed speed;
    private List<Character> mainGroup;
    private List<Character> secondaryGroup;

    public Scene() {
        this.mainGroup = new ArrayList<>();
        this.secondaryGroup = new ArrayList<>();
        // this.isSpinning = false;
        this.speed = Speed.MEDIUM;
    }

    public void play() {
        story.tell();
    }

    public Character getCharacter(String name) throws CharacterNotExistsException {
        for (Character person : mainGroup) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        throw new CharacterNotExistsException();
    }

    public Character getMainCharacter() {
        return getCharacters().get(0);
    }

    public void addGroupParticipant(Character person) {
        secondaryGroup.add(person);
    }

    public void addCharacter(Character person) {
        mainGroup.add(person);
    }

    public Tellable getStory() {
        return story;
    }

    public void setStory(Tellable story) {
        this.story = story;
    }

    public List<Character> getCharacters() {
        return mainGroup;
    }

    public void setCharacters(List<Character> characters) {
        this.mainGroup = characters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scene scene = (Scene) o;
        return Objects.equals(story, scene.story) && Objects.equals(mainGroup, scene.mainGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(story, mainGroup);
    }

    @Override
    public String toString() {
        return "Scene{" +
                "story=" + story +
                ", characters=" + mainGroup +
                '}';
    }

    public void isSpinning(Boolean value) {
        isSpinning = value;
    }

    public String spin(Speed newSpeed) {
        if (this.isSpinning == null) {
            throw new SceneCanNotStayException();
        }
        if (newSpeed != speed) {
            this.speed = newSpeed;
            String isSpiningScene;
            if (isSpinning) isSpiningScene = "Вращающаяся";
            else isSpiningScene = "Не вращающаяся";
            return isSpiningScene + " сцена закружилась с " + speed.name + " быстротой";
        } else {
            return "сцена же продолжала вертеться вместе со всеми";
        }
    }

    public String setSpeed(Speed speed) {
        return "Все произошло так " + speed.name;
    }

    public String crashMainGroup() throws NotEnoughCharactersException {
        if (mainGroup.size() > 1) {
            for (Character character : mainGroup) {
                character.setBalance(false);
            }
            return "Все потеряли равновесие и попадали друг на друга";
        } else {
            throw new NotEnoughCharactersException();
        }
    }

    public String setVisionToMainGroup() {
        if (this.isSpinning == null) {
            throw new SceneCanNotStayException();
        }
        String hardToSee;
        if (this.isSpinning) hardToSee = "трудно";
        else hardToSee = "не трудно";
        return "зрителям было " + hardToSee + " уследить за событиями";
    }

    public String attackCharacter(Character victim) {
        return "А " + secondaryGroup.size() + " лесных малыша набросились на " + victim.getName();
    }

    public String attachToCharacter(Character victim) {
        final String[] answer = {""};
        victim.getItems().forEach(item ->
                answer[0] = answer[0] + item.name
        );
        return "вцепились в его " + answer[0];
    }
}
