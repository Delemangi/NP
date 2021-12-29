package k2.fileSystem;

import java.util.*;
import java.util.stream.*;
import java.time.*;

public class FileSystem {
    private final Map<Character, Folder> folders;

    public FileSystem() {
        this.folders = new HashMap<>();
    }

    public void addFile(char folder, String name, int size, LocalDateTime createdAt) {
        folders.putIfAbsent(folder, new Folder());
        folders.get(folder).addFile(new File(name, size, createdAt));
    }

    public List<File> findAllHiddenFilesWithSizeLessThen(int size) {
        return folders.values().stream().flatMap(folder -> folder.getFiles().stream().filter(file -> file.isHidden() && file.getSize() < size)).collect(Collectors.toList());
    }

    public int totalSizeOfFilesFromFolders(List<Character> list) {
        return folders.entrySet().stream().filter(folder -> list.contains(folder.getKey())).flatMapToInt(folder -> folder.getValue().getFiles().stream().mapToInt(File::getSize)).sum();
    }

    public Map<Integer, Set<File>> byYear() {
        Map<Integer, Set<File>> map = new HashMap<>();

        folders.values().forEach(folder -> folder.getFiles().forEach(file -> {
            map.putIfAbsent(file.getYear(), new HashSet<>());
            map.get(file.getYear()).add(file);
        }));

        return map;
    }

    public Map<String, Long> sizeByMonthAndDay() {
        Map<String, Long> map = new HashMap<>();

        folders.values().forEach(folder -> folder.getFiles().forEach(file -> {
            String key = String.format("%s-%d", file.getMonth(), file.getDayOfMonth());

            map.putIfAbsent(key, 0L);
            map.compute(key, (k, v) -> v + file.getSize());
        }));

        return map;
    }
}