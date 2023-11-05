package ispit.messageSystem;

import java.util.*;
import java.util.stream.Collectors;

public class Topic {
    private final String topicName;
    private int partitionsCount;
    private final Map<Integer, SortedSet<Message>> messages;

    public Topic(String topicName, int partitionsCount) {
        this.topicName = topicName;
        this.partitionsCount = partitionsCount;
        this.messages = new HashMap<>();
    }

    @Override
    public String toString() {
        return String.format("Topic: %10s Partitions: %5d%n%s",
                topicName,
                partitionsCount,
                messages
                        .entrySet()
                        .stream()
                        .map(e -> String.format("%2d: Count of messages: %5d%n%s",
                                        e.getKey(),
                                        e.getValue().size(),
                                        !e.getValue().isEmpty() ? String.format("Messages:%n%s",
                                                e
                                                        .getValue()
                                                        .stream()
                                                        .map(Message::toString)
                                                        .collect(Collectors.joining("\n")))
                                                : ""
                                )
                        )
        );
    }

    public void addMessage(Message message) throws PartitionDoesNotExistException {
        Integer partition = message.getPartition();

        if (partition == null) {
            partition = PartitionAssigner.assignPartition(message, partitionsCount);
        }

        if (partitionsCount < partition) {
            throw new PartitionDoesNotExistException(topicName, partition);
        }

        messages.putIfAbsent(partition, new TreeSet<>());
        messages.computeIfPresent(partition, (k, v) -> {
            if (v.size() == MessageBroker.TOPIC_SIZE) {
                v.remove(v.first());
            }

            v.add(message);

            return v;
        });
    }

    public void changeNumberOfPartitions(int newPartitionsCount) throws UnsupportedOperationException {
        if (partitionsCount > newPartitionsCount) {
            throw new UnsupportedOperationException("Partitions number cannot be decreased!");
        }

        partitionsCount = newPartitionsCount;
    }
}