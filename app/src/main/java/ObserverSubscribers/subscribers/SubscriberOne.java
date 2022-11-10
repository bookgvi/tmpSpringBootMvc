package ObserverSubscribers.subscribers;

import ObserverSubscribers.Configuration;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.util.*;

@Service
public class SubscriberOne implements ISubscriber {
    private final String subscriberName = this.getClass().getSimpleName();
    private final String subscriberClass = this.getClass().getName();

    @Override
    public void subscribe() {
        Properties props = new Properties();
        Map<String, String> map = Map.of("k", "v");
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        try {
            props.load(this.getClass().getResourceAsStream(Configuration.SUBSCRIBERS_LIST));
            if (props.containsKey(subscriberName) || props.containsValue(subscriberClass)) {
                System.out.println("Already subscribe");
                return;
            }
            props.setProperty(subscriberName, subscriberClass);
            FileOutputStream fileOutputStream = new FileOutputStream(Configuration.SUBSCRIBERS_FILE);
            props.store(fileOutputStream, null);
            fileOutputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception has been generated..." + ex.getMessage());
        }
    }

    @Override
    public void showNotification(String text) {
        System.out.println(text);
    }

}
