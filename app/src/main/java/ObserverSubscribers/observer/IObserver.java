package ObserverSubscribers.observer;

import java.lang.reflect.InvocationTargetException;

public interface IObserver {
    void sendMessage() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;
}
