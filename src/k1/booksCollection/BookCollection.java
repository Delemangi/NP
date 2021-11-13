package k1.booksCollection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BookCollection {
    private final List<Book> list;

    public BookCollection() {
        this.list = new ArrayList<>();
    }

    public void addBook(Book book) {
        list.add(book);
    }

    public void printByCategory(String category) {
        list.stream().sorted().filter(i -> i.getCategory().equalsIgnoreCase(category)).forEach(System.out::println);
    }

    public List<Book> getCheapestN(int n) {
        return list.stream().sorted(Comparator.comparing(Book::getPrice).thenComparing(Book::getTitle)).limit(n).collect(Collectors.toList());
    }
}