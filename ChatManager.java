package prog5121;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages chat operations, message storage arrays, and status flags.
 */
public class ChatManager implements ChatInterface {
    private List<Message> messageStore;

    public ChatManager() {
        this.messageStore = new ArrayList<>();
    }

    @Override
    public boolean sendMessage(String recipientCell, String payload) {
        if (recipientCell == null || recipientCell.isEmpty() || payload == null) {
            return false;
        }
        Message newMessage = new Message(recipientCell, payload);
        newMessage.setSent(true); // Flag: Message Sent
        messageStore.add(newMessage);
        return true;
    }

    @Override
    public boolean receiveMessage(Message message) {
        if (message != null && message.isSent()) {
            message.setReceived(true); // Flag: Message Received
            return true;
        }
        return false;
    }

    @Override
    public boolean readMessage(Message message) {
        if (message != null && message.isReceived()) {
            message.setRead(true); // Flag: Message Read
            return true;
        }
        return false;
    }

    public List<Message> getMessageStore() {
        return messageStore;
    }
}