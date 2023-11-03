package enums;

public enum Mood {

    HAPPY("весело"),
    SAD("Грустно"),
    ANGRY("Сердито"),
    EXCITED("взволнованно"),
    CALM("Спокойно"),
    ANXIOUS("ТРЕВОЖНО"),
    NEUTRAL("Нейтрально"),
    JOYFUL("Радостно"),
    DEPRESSED("Депрессивно"),
    ELATED("с восторгом"),
    FRUSTRATED("РАЗОЧАРОВАННО"),
    RELAXED("Расслабленно"),
    VICTORIOUSLY("победно"),
    Contemptuously("презрительно");

    private final String name;

    Mood(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
