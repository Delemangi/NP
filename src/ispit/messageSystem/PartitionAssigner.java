package ispit.messageSystem;

public class PartitionAssigner {
    public static Integer assignPartition(Message message, int partitionsCount) {
        return (Math.abs(message.getKey().hashCode()) % partitionsCount) + 1;
    }
}