package ObserverSubscribers.DataSource;

import ObserverSubscribers.Configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PropsSource implements ISubscriberSource {
    @Override
    public List<String> getList() throws IOException {
        List<String> subscriberList = new ArrayList<>();
        Properties props = new Properties();
        props.load(this.getClass().getResourceAsStream(Configuration.SUBSCRIBERS_LIST));
        for (Object o : props.values()) {
            String subName = (String) o;
            subscriberList.add(subName);
        }
        return subscriberList;
    }
}
