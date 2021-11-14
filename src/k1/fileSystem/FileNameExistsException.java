package k1.fileSystem;

public class FileNameExistsException extends Exception {
    public FileNameExistsException(String file, String folder) {
        super(String.format("There is already a file named %s in the folder %s", file, folder));
    }
}