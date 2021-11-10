package k1.arhivaSoLocalDate;

import java.time.LocalDate;

public abstract class Archive {
    private final int ID;
    private LocalDate dateArchived;

    protected Archive(int ID) {
        this.ID = ID;
    }

    public void setDateArchived(LocalDate dateArchived) {
        this.dateArchived = dateArchived;
    }

    public int getID() {
        return ID;
    }

    public LocalDate getDateArchived() {
        return dateArchived;
    }
}