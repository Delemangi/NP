package k1.arhivaSoLocalDate;

import java.time.LocalDate;

public class LockedArchive extends Archive {
    private final LocalDate dateToOpen;

    public LockedArchive(int ID, LocalDate dateToOpen) {
        super(ID);
        this.dateToOpen = dateToOpen;
    }

    public LocalDate getDateToOpen() {
        return dateToOpen;
    }
}