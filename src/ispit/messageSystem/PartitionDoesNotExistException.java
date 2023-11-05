package ispit.messageSystem;

public class PartitionDoesNotExistException extends Exception {
    public PartitionDoesNotExistException(String topicName, int partition) {
        super(String.format("The topic %s does not have a partition with number %d", topicName, partition));
    }
}