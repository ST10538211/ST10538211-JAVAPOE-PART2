package prog5121;

/**
 * Represents a single chat message payload, tracking recipient,
 * message text, and delivery status flags (sent, received, read).
 */
public class Message {
    private String recipientCellNumber;
    private String messagePayload;
    private boolean isSent;
    private boolean isReceived;
    private boolean isRead;

    public Message(String recipientCellNumber, String messagePayload) {
        this.recipientCellNumber = recipientCellNumber;
        this.messagePayload = messagePayload;
        this.isSent = false;
        this.isReceived = false;
        this.isRead = false;
    }

    public String getRecipientCellNumber() {
        return recipientCellNumber;
    }

    public void setRecipientCellNumber(String recipientCellNumber) {
        this.recipientCellNumber = recipientCellNumber;
    }

    public String getMessagePayload() {
        return messagePayload;
    }

    public void setMessagePayload(String messagePayload) {
        this.messagePayload = messagePayload;
    }

    public boolean isSent() {
        return isSent;
    }

    public void setSent(boolean sent) {
        isSent = sent;
    }

    public boolean isReceived() {
        return isReceived;
    }

    public void setReceived(boolean received) {
        isReceived = received;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}