package lab2.kontakti;

public abstract class Contact {
    private final int year;
    private final int month;
    private final int day;

    public Contact(String date) {
        this.year = Integer.parseInt(date.split("-")[0]);
        this.month = Integer.parseInt(date.split("-")[1]);
        this.day = Integer.parseInt(date.split("-")[2]);
    }

    public abstract String getType();

    private long getDays() {
        return year * 365L + month * 30L + day;
    }

    public boolean isNewerThan(Contact c) {
        return getDays() > c.getDays();
    }
}