package k1.fileSystem;

public interface IFile extends Comparable<IFile> {
    String getFileName();

    long getFileSize();

    String getFileInfo(int indent);

    void sortBySize();

    long findLargestFile();

    @Override
    default int compareTo(IFile o) {
        return Long.compare(getFileSize(), o.getFileSize());
    }
}