package ObserverSubscribers.DataSource;

import java.io.IOException;
import java.util.List;

public interface ISubscriberSource {
    List<String> getList() throws IOException;
}
