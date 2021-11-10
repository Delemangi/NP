package k1.arhiva;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArchiveStore {
    private final List<Archive> list;
    private final StringBuilder log;

    public ArchiveStore() {
        this.list = new ArrayList<Archive>();
        this.log = new StringBuilder();
    }

    void archiveItem(Archive item, Date date) {
        item.setDateArchived(date);
        list.add(item);
        log.append(String.format("Item %d archived at %s%n", item.getID(), date.toString().replace("GMT", "UTC")));
    }

    void openItem(int ID, Date date) throws NonExistingItemException {
        Archive a = null;

        for (Archive archive : list) {
            if (archive.getID() == ID) {
                a = archive;
                break;
            }
        }

        if (a == null) {
            throw new NonExistingItemException(String.format("Item with id %d doesn't exist", ID));
        } else if (a instanceof LockedArchive) {
            if (date.before(((LockedArchive) a).getDateToOpen())) {
                log.append(String.format("Item %d cannot be opened before %s%n", a.getID(), ((LockedArchive) a).getDateToOpen().toString().replace("GMT", "UTC")));
            } else {
                log.append(String.format("Item %d opened at %s%n", a.getID(), date.toString().replace("GMT", "UTC")));
            }
        } else {
            if (((SpecialArchive) a).getCurrentOpen() == ((SpecialArchive) a).getMaxOpen()) {
                log.append(String.format("Item %d cannot be opened more than %d times%n", a.getID(), ((SpecialArchive) a).getMaxOpen()));
            } else {
                log.append(String.format("Item %d opened at %s%n", a.getID(), date.toString().replace("GMT", "UTC")));
                ((SpecialArchive) a).increaseCurrentOpen();
            }
        }
    }

    public String getLog() {
        return log.toString();
    }
}