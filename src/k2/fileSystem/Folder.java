package k2.fileSystem;

import java.util.*;

public class Folder {
    private final Set<File> files;

    public Folder() {
        this.files = new TreeSet<>();
    }

    public void addFile(File file) {
        files.add(file);
    }

    public Set<File> getFiles() {
        return files;
    }
}