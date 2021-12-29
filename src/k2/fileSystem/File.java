package k2.fileSystem;

import java.util.*;
import java.time.*;

public class File implements Comparable<File> {
    private final String name;
    private final int size;
    private final LocalDateTime createdAt;

    public File(String name, int size, LocalDateTime createdAt) {
        this.name = name;
        this.size = size;
        this.createdAt = createdAt;
    }

    @Override
    public int compareTo(File o) {
        return Comparator.comparing(File::getCreatedAt).thenComparing(File::getName).thenComparing(File::getSize).compare(this, o);
    }

    @Override
    public String toString() {
        return String.format("%-10s %5dB %s", name, size, createdAt);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return size == file.size && name.equals(file.name) && createdAt.equals(file.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size, createdAt);
    }

    public boolean isHidden() {
        return name.charAt(0) == '.';
    }

    public int getYear() {
        return createdAt.getYear();
    }

    public String getMonth() {
        return createdAt.getMonth().toString();
    }

    public int getDayOfMonth() {
        return createdAt.getDayOfMonth();
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}