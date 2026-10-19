package prog5121;

/**
 * Interface defining mandatory chat operations for the messaging system.
 */
public interface ChatInterface {
    boolean sendMessage(String recipientCell, String payload);
    boolean receiveMessage(Message message);
    boolean readMessage(Message message);
}