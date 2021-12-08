package lab7.administracijaNaCetSistem;

public class NoSuchRoomException extends Exception {
    NoSuchRoomException(String name) {
        super(String.format("Room %s doesn't exists!", name));
    }
}