package SpringQuickly.comments.proxies;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("PUSH")
public class PushProxyImpl implements IProxy {
    @Override
    public void send(String text) {
        System.out.printf("\"%s\" has been pushed\n", text);
    }
}
