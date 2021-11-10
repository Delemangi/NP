package k1.naslovnaStranica;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TextNewsItem extends NewsItem {
    private final String text;

    public TextNewsItem(String title, Date date, Category category, String text) {
        super(title, date, category);
        this.text = text;
    }

    @Override
    public String getTeaser() {
        long duration = Calendar.getInstance().getTime().getTime() - date.getTime();

        return String.format("%s%n%d%n%.80s%n", title, TimeUnit.MILLISECONDS.toMinutes(duration), text);
    }
}