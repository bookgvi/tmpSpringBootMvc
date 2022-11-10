package SpringQuickly.comments.service;

import SpringQuickly.comments.proxies.IProxy;
import SpringQuickly.comments.repository.IRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class CommentService {
    private final IProxy proxy;
    private final IRepository repo;

    public CommentService(@Qualifier("PUSH") IProxy proxy, IRepository repo) {
        this.proxy = proxy;
        this.repo = repo;
    }

    public void publishComment(String text) {
        proxy.send(text);
        repo.stored(text);
    }
}
