package SpringQuickly.comments.main;

import SpringQuickly.comments.configuration.ProjectConfig;
import SpringQuickly.comments.proxies.IProxy;
import SpringQuickly.comments.proxies.MailProxyImpl;
import SpringQuickly.comments.repository.DbRepositoryImpl;
import SpringQuickly.comments.repository.IRepository;
import SpringQuickly.comments.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        springStart();
        manuallyStart();
    }

    private static void springStart() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ProjectConfig.class);
        CommentService service = ctx.getBean(CommentService.class);
        service.publishComment("QQQ");
    }

    private static void manuallyStart() {
        IProxy proxy = new MailProxyImpl();
        IRepository dbRepo = new DbRepositoryImpl();
        CommentService service = new CommentService(proxy, dbRepo);
        service.publishComment("Comment");
    }
}
