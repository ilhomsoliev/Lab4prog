import enums.Item;
import enums.Mood;
import enums.Speed;
import exceptions.checked.CharacterNotExistsException;
import exceptions.checked.NotEnoughCharactersException;
import exceptions.unchecked.SceneCanNotStayException;
import interfaces.Action;
import interfaces.Callback;
import models.actions.HeardAction;
import models.actions.LaughAction;
import models.charackter.Character;
import models.scene.Scene;
import models.scene.Sentence;
import models.scene.Story;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        var story = new Story();

        var scene = new Scene();
        setupCharacters(scene);

        Character mainCharacter = scene.getMainCharacter();
        scene.isSpinning(true);

        try {
            story.addSentence(new Sentence(scene.spin(Speed.EXTREME)));
        } catch (SceneCanNotStayException exception) {
            story.addSentence(new Sentence("Сцена почему-то не крутится :("));
        }

        story.addSentence(new Sentence(new HeardAction("Они", new LaughAction(mainCharacter).perform()).perform()).but(new LaughAction(mainCharacter, Mood.VICTORIOUSLY, Mood.HAPPY, Mood.ANGRY).perform()));

        try {
            story.addSentence(new Sentence(scene.setSpeed(Speed.SLOW)).that(scene.setVisionToMainGroup()));
        } catch (SceneCanNotStayException exception) {
            story.addSentence(new Sentence("Сцена почему-то не крутится :("));
        }
        try {
            story.addSentence(new Sentence(scene.crashMainGroup()).custom("; ", scene.spin(Speed.EXTREME)));
        } catch (NotEnoughCharactersException exception) {
            story.addSentence(new Sentence(scene.spin(Speed.EXTREME)));
        }

        try {
            story.addSentence(new Sentence(scene.attackCharacter(scene.getCharacter("Хемуля"))).and(scene.attachToCharacter(scene.getCharacter("Хемуля"))));
        } catch (CharacterNotExistsException exception) {
            story.addSentence(new Sentence("Никто не пострадал :)"));
        }

        scene.setStory(story);
        scene.play();
    }

    private static void setupCharacters(Scene scene) {
        scene.addCharacter(
                new Character.Builder()
                        .setName("Эмма")
                        .setMoods(Mood.Contemptuously)
                        .setIsBalanceOk(true)
                        .setItems(List.of(Item.BAG, Item.FLASHLIGHT))
                        .build()
        );
        scene.addCharacter(
                new Character.Builder()
                        .setName("Misa")
                        .setMoods(Mood.HAPPY)
                        .setIsBalanceOk(true)
                        .build()
        );
        scene.addCharacter(
                new Character.Builder()
                        .setName("Snork")
                        .setMoods(Mood.HAPPY)
                        .setIsBalanceOk(true)
                        .build()
        );
        scene.addCharacter(
                new Character.Builder()
                        .setName("Хемуля")
                        .setMoods(Mood.HAPPY)
                        .setIsBalanceOk(true)
                        .setItems(List.of(Item.POLICE_UNIFORM))
                        .build()
        );

        int groupSize = 24;
        for (int i = 1; i <= groupSize; i++) {
            scene.addGroupParticipant(
                    new Character.Builder()
                            .setName("лесной малыш #" + i)
                            .setMoods(Mood.ANGRY)
                            .setItems(List.of(Item.PAWS))
                            .build()
            );
        }
    }
}