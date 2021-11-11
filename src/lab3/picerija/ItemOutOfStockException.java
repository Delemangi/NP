package lab3.picerija;

public class ItemOutOfStockException extends Exception {
    public ItemOutOfStockException(int i) {
        super(String.format("%d", i));
    }
}