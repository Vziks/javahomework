package info.vziks.homework17.App;

import java.io.Serializable;
import java.net.SocketAddress;
import java.time.LocalDateTime;

public class Message implements Serializable {
    private String sender;
    private String text;
    private SocketAddress socketAddress;
    private LocalDateTime dateTime;

    public Message(String sender, String messageText) {
        setSender(sender);
        setText(messageText);
        dateTime = LocalDateTime.now();
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        if (sender != null && !"".equals(sender)) {
            this.sender = sender;
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        if (text != null && !"".equals(text)) {
            this.text = text;
        }
    }

    public SocketAddress getSocketAddress() {
        return socketAddress;
    }

    public Message setSocketAddress(SocketAddress socketAddress) {
        this.socketAddress = socketAddress;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Message{");
        sb.append("sender='").append(sender).append('\'');
        sb.append(", text='").append(text).append('\'');
        sb.append(", socketAddress=").append(socketAddress);
        sb.append(", dateTime=").append(dateTime);
        sb.append('}');
        return sb.toString();
    }
}
