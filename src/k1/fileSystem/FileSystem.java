package k1.fileSystem;

public class FileSystem {
    private final Folder root;

    public FileSystem() {
        this.root = new Folder("root");
    }

    public void addFile(IFile f) throws FileNameExistsException {
        root.addFile(f);
    }

    public long findLargestFile() {
        return root.findLargestFile();
    }

    public void sortBySize() {
        root.sortBySize();
    }

    @Override
    public String toString() {
        return root.getFileInfo(0);
    }
}