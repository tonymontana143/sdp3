package sdp3;

// Client code
public class Main {
    public static void main(String[] args) {
        // Existing system
        LegacyMessageSender legacySender = new LegacyMessageSender();

        // Adapter
        MessageSender adapter = new LegacyMessageAdapter(legacySender);

        // Using the adapter to send a message
        adapter.sendMessage("Hello, Legacy System!");
    }
}

// target interface
interface MessageSender {
    void sendMessage(String message);
}

// adaptee interface
class LegacyMessageSender {
    void send(String text) {
        System.out.println("Legacy system sends: " + text);
    }
}

// adapter class
class LegacyMessageAdapter implements MessageSender {
    private LegacyMessageSender legacySender;

    public LegacyMessageAdapter(LegacyMessageSender legacySender) {
        this.legacySender = legacySender;
    }

    @Override
    public void sendMessage(String message) {
        legacySender.send(message);
    }
}

