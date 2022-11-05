package ObserverSubscribers;

import ObserverSubscribers.DataSource.DBSource;
import ObserverSubscribers.DataSource.PropsSource;
import ObserverSubscribers.observer.IObserver;
import ObserverSubscribers.observer.Observer;
import ObserverSubscribers.subscribers.ISubscriber;
import ObserverSubscribers.subscribers.SubscriberOne;
import ObserverSubscribers.subscribers.SubscriberThree;
import ObserverSubscribers.subscribers.SubscriberTwo;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        ISubscriber sub1 = new SubscriberOne();
        ISubscriber sub2 = new SubscriberTwo();
        ISubscriber sub3 = new SubscriberThree();
        sub1.subscribe();
        sub2.subscribe();
        sub3.subscribe();

        IObserver observer1 = new Observer(new PropsSource());
        observer1.sendMessage();

        IObserver observer2 = new Observer(new DBSource());
        observer2.sendMessage();
    }
}
