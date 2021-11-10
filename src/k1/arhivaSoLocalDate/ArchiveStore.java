package k1.arhivaSoLocalDate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArchiveStore {
    private final List<Archive> list;
    private final StringBuilder log;

    public ArchiveStore() {
        this.list = new ArrayList<Archive>();
        this.log = new StringBuilder();
    }

    void archiveItem(Archive item, LocalDate date) {
        item.setDateArchived(date);
        list.add(item);
        log.append(String.format("Item %d archived at %s%n", item.getID(), date.toString()));
    }

    void openItem(int ID, LocalDate date) throws NonExistingItemException {
        Archive a = null;

        for (Archive archive : list) {
            if (archive.getID() == ID) {
                a = archive;
                break;
            }
        }

        if (a == null) {
            throw new NonExistingItemException(String.format("Item with id %d doesn't exist", ID));
        } else if (a instanceof LockedArchive e) {
            if (date.isBefore(((LockedArchive) a).getDateToOpen())) {
                log.append(String.format("Item %d cannot be opened before %s%n", a.getID(), ((LockedArchive) a).getDateToOpen().toString()));
            } else {
                log.append(String.format("Item %d opened at %s%n", a.getID(), date.toString()));
            }
        } else {
            if (((SpecialArchive) a).getCurrentOpen() == ((SpecialArchive) a).getMaxOpen()) {
                log.append(String.format("Item %d cannot be opened more than %d times%n", a.getID(), ((SpecialArchive) a).getMaxOpen()));
            } else {
                log.append(String.format("Item %d opened at %s%n", a.getID(), date.toString()));
                ((SpecialArchive) a).increaseCurrentOpen();
            }
        }
    }

    public String getLog() {
        return log.toString();
    }
}