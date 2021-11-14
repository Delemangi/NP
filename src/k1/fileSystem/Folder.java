package k1.fileSystem;

import java.util.ArrayList;
import java.util.List;

public class Folder implements IFile {
    private final String name;
    private final List<IFile> list;

    public Folder(String name) {
        this.name = name;
        this.list = new ArrayList<>();
    }

    private boolean duplicateCheck(IFile file) {
        for (IFile f : list) {
            if (f.getFileName().equals(file.getFileName())) {
                return true;
            }
        }

        return false;
    }

    public void addFile(IFile file) throws FileNameExistsException {
        if (duplicateCheck(file)) {
            throw new FileNameExistsException(file.getFileName(), name);
        }

        list.add(file);
    }

    @Override
    public String getFileName() {
        return name;
    }

    @Override
    public long getFileSize() {
        return list.stream().mapToLong(IFile::getFileSize).sum();
    }

    @Override
    public String getFileInfo(int indent) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < indent; i++) {
            sb.append("\t");
        }
        sb.append(String.format("Folder name: %10s Folder size: %10d%n", getFileName(), getFileSize()));

        for (IFile f : list) {
            sb.append(f.getFileInfo(indent + 1));
        }

        return sb.toString();
    }

    @Override
    public void sortBySize() {
        list.sort(IFile::compareTo);

        for (IFile f : list) {
            f.sortBySize();
        }
    }

    @Override
    public long findLargestFile() {
        return list.stream().mapToLong(IFile::findLargestFile).max().orElse(0);
    }
}