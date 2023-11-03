package enums;

public enum Item {
    FLASHLIGHT("карманный фонарик"), BAG("sumochka"), POLICE_UNIFORM("полицейский мундир"),
    PAWS("Лапы");

    public final String name;

    Item(String name) {
        this.name = name;
    }
}
