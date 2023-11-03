package exceptions.checked;

public class CharacterNotExistsException extends Exception  {
    public CharacterNotExistsException() {
        super("No character found");
    }
}
