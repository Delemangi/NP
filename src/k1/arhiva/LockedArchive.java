package k1.arhiva;

import java.util.Date;

public class LockedArchive extends Archive {
    private final Date dateToOpen;

    public LockedArchive(int ID, Date dateToOpen) {
        super(ID);
        this.dateToOpen = dateToOpen;
    }

    public Date getDateToOpen() {
        return dateToOpen;
    }
}