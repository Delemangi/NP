package ispit.messageSystem;

import java.util.*;
import java.time.*;

public class MessageBroker {
    private final Map<String, Topic> topics;
    public static LocalDateTime EARLIEST;
    public static int TOPIC_SIZE;

    public MessageBroker(LocalDateTime ldt, int size) {
        this.topics = new HashMap<>();
        EARLIEST = ldt;
        TOPIC_SIZE = size;
    }

    public void addTopic(String topic, int partitionsCount) {
        if (!topics.containsKey(topic)) {
            topics.put(topic, new Topic(topic, partitionsCount));
        }
    }

    public void addMessage(String topic, Message message) {

    }
}