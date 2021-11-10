package k1.naslovnaStranica;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MediaNewsItem extends NewsItem {
    private final String url;
    private final int views;

    public MediaNewsItem(String title, Date date, Category category, String url, int views) {
        super(title, date, category);
        this.url = url;
        this.views = views;
    }

    @Override
    public String getTeaser() {
        long duration = Calendar.getInstance().getTime().getTime() - date.getTime();

        return String.format("%s%n%d%n%s%n%d%n", title, TimeUnit.MILLISECONDS.toMinutes(duration), url, views);
    }
}