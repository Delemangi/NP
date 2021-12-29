package k2.kalendarNaNastani;

public class WrongDateException extends Exception {
    public WrongDateException(String string) {
        super(String.format("Wrong date: %s", string));
    }
}
