package SpringQuickly.singletone.config;

import SpringQuickly.singletone.service.IService;
import SpringQuickly.singletone.service.MailServiceImpl;
import SpringQuickly.singletone.service.PushServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "SpringQuickly.singletone.service")
public class ProjectConfig {
    @Bean
    IService mailService() {
        return MailServiceImpl.INSTANCE;
    }

    @Bean(name = "pushSingletone1")
    IService pushService1() {
        return PushServiceImpl.INSTANCE;
    }

    @Bean(name = "pushSingletone2")
    IService pushService2() {
        return PushServiceImpl.INSTANCE;
    }
    @Bean(name = "pushServiceSingletoneScope2")
    IService pushService3() {
        return new PushServiceImpl();
    }
}
