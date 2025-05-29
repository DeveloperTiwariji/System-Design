//<========================================Observer Design Pattern========================================>
import java.util.*;


interface Channel {
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    void notifySubscribers(String message);
}

class YouTubeChannel implements Channel {
    private List<Subscriber> subscribers = new ArrayList<>();

    @Override
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(String message) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(message);
        }
    }
}

interface Subscriber {
    void update(String message);
}

class YouTubeSubscriber implements Subscriber {
    private String name;

    public YouTubeSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received message: " + message);
    }
}

public class ODPExample {
    public static void main(String[] args) {
        YouTubeChannel channel = new YouTubeChannel();

        Subscriber subscriber1 = new YouTubeSubscriber("Alice");
        Subscriber subscriber2 = new YouTubeSubscriber("Bob");

        channel.subscribe(subscriber1);
        channel.subscribe(subscriber2);

        channel.notifySubscribers("New video uploaded!");

        channel.unsubscribe(subscriber1);

        channel.notifySubscribers("Another video uploaded!");
    }
}