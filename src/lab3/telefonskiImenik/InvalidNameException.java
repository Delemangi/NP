package lab3.telefonskiImenik;

public class InvalidNameException extends Exception {
    public String name;

    public InvalidNameException(String name) {
        super();
        this.name = name;
    }
}