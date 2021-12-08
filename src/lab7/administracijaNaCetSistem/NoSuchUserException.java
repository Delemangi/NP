package lab7.administracijaNaCetSistem;

public class NoSuchUserException extends Exception {
    public NoSuchUserException(String name) {
        super(String.format("User %s doesn't exists!", name));
    }
}