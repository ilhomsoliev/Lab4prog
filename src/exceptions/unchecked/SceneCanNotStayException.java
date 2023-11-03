package exceptions.unchecked;

public class SceneCanNotStayException  extends RuntimeException{
    public SceneCanNotStayException() {
        super("Scene Can not stay");
    }
}
