package ObserverSubscribers.observer;

import ObserverSubscribers.DataSource.ISubscriberSource;
import ObserverSubscribers.subscribers.ISubscriber;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Observer implements IObserver {
    private final List<String> subscriberList = new ArrayList<>();

    public Observer(ISubscriberSource subscriberSource) throws IOException {
        subscriberList.addAll(subscriberSource.getList());
    }

    public void sendMessage() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        if (subscriberList.size() > 0) {
            for (String subscriberName : subscriberList) {
                ISubscriber sub = (ISubscriber) Class.forName(subscriberName).getDeclaredConstructor().newInstance();
                sub.showNotification("Hello, " + subscriberName);
            }
        }
    }
}
