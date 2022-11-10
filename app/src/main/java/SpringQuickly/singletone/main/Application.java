package SpringQuickly.singletone.main;

import SpringQuickly.singletone.config.ProjectConfig;
import SpringQuickly.singletone.service.PushServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

public class Application {
    private static Logger logger = Logger.getLogger(Application.class.getName());

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ProjectConfig.class);
        logger.info("Context created:\n\t" + ctx.getDisplayName());

//        IService mailService = ctx.getBean(MailServiceImpl.class);


        PushServiceImpl pushServiceSingle1 = ctx.getBean("pushSingletone1", PushServiceImpl.class);
        PushServiceImpl pushServiceSingle2 = ctx.getBean("pushSingletone2", PushServiceImpl.class);
        PushServiceImpl pushServiceSingletoneScope1 = ctx.getBean("pushServiceSingletoneScope1", PushServiceImpl.class);
        PushServiceImpl pushServiceSingletoneScope2 = ctx.getBean("pushServiceSingletoneScope2", PushServiceImpl.class);
        logger.info("PushServiceBean1:\n\t" + pushServiceSingle1.getClass().getName());
        logger.info("PushServiceBean2:\n\t" + pushServiceSingle1.getClass().getName());

        pushServiceSingle1.setChf("1");
        pushServiceSingletoneScope1.setChf("2");
        System.out.println(pushServiceSingle1.getChf());
        System.out.println(pushServiceSingle2.getChf());
        System.out.println(pushServiceSingletoneScope1.getChf());
        System.out.println(pushServiceSingletoneScope2.getChf());

    }
}
