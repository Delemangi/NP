package ispit.messageSystem;

import java.util.*;
import java.time.*;

public class Message implements Comparable<Message> {
    private final LocalDateTime timestamp;
    private final String message;
    private final String key;
    private final Integer partition;

    public Message(LocalDateTime timestamp, String message, String key) {
        this.timestamp = timestamp;
        this.message = message;
        this.key = key;
        this.partition = null;
    }

    public Message(LocalDateTime timestamp, String message, Integer partition, String key) {
        this.timestamp = timestamp;
        this.message = message;
        this.key = key;
        this.partition = partition;
    }

    @Override
    public String toString() {
        return "Message{" + "timestamp=" + timestamp +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public int compareTo(Message o) {
        return Comparator.comparing(Message::getTimestamp).compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message1 = (Message) o;
        return timestamp.equals(message1.timestamp) && message.equals(message1.message) && key.equals(message1.key) && Objects.equals(partition, message1.partition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, message, key, partition);
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getKey() {
        return key;
    }

    public Integer getPartition() {
        return partition;
    }
}