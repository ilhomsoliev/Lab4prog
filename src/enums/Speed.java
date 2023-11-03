package enums;

public enum Speed {
    SLOW("медленно"), MEDIUM("нормально"), FAST("быстро"), EXTREME("невероятной");
    public final String name;

    Speed(String name) {
        this.name = name;
    }
}
