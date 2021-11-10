package k1.arhiva;

import java.util.Date;

public abstract class Archive {
    private final int ID;
    private Date dateArchived;

    protected Archive(int ID) {
        this.ID = ID;
    }

    public void setDateArchived(Date dateArchived) {
        this.dateArchived = dateArchived;
    }

    public int getID() {
        return ID;
    }

    public Date getDateArchived() {
        return dateArchived;
    }
}