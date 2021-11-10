package lab3.picerija;

public class ItemOutOfStockException extends Exception {
    public ItemOutOfStockException(Item item) {
        super("");
    }
}