package k1.fileSystem;

public class File implements IFile {
    private final String name;
    private final long size;

    public File(String name, long size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getFileName() {
        return name;
    }

    @Override
    public long getFileSize() {
        return size;
    }

    @Override
    public String getFileInfo(int indent) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < indent; i++) {
            sb.append("\t");
        }
        sb.append(String.format("File name: %10s File size: %10d%n", getFileName(), getFileSize()));

        return sb.toString();
    }

    @Override
    public void sortBySize() {
        // does nothing
    }

    @Override
    public long findLargestFile() {
        return size;
    }
}