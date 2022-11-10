package SpringQuickly.comments.proxies;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("EMAIL")
public class MailProxyImpl implements IProxy {
    @Override
    public void send(String text) {
        System.out.printf("\"%s\" has been sent by e-mail\n", text);
    }
}
