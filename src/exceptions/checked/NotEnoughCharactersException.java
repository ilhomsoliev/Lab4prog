package exceptions.checked;

public class NotEnoughCharactersException extends Exception {
    public NotEnoughCharactersException() {
        super("Not enough people to crash");
    }
}
