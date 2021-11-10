package k1.naslovnaStranica;

import java.util.Date;

public abstract class NewsItem {
    protected String title;
    protected Date date;
    protected Category category;

    protected NewsItem(String title, Date date, Category category) {
        this.title = title;
        this.date = date;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public abstract String getTeaser();

    @Override
    public String toString() {
        return getTeaser();
    }
}