package k1.arhiva;

public class NonExistingItemException extends Exception {
    public NonExistingItemException(String message) {
        super(message);
    }
}