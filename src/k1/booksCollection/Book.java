package k1.booksCollection;

public class Book implements Comparable<Book> {
    private final String title;
    private final String category;
    private final float price;

    public Book(String title, String category, float price) {
        this.title = title;
        this.category = category;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public int compareTo(Book o) {
        return title.compareTo(o.title) == 0 ? Float.compare(price, o.price) : title.compareTo(o.title);
    }

    @Override
    public String toString() {
        return String.format("%s (%s) %.2f", title, category, price);
    }
}