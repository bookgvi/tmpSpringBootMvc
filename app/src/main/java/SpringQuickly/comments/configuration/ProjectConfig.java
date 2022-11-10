package SpringQuickly.comments.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"SpringQuickly.comments.proxies", "SpringQuickly.comments.repository", "SpringQuickly.comments.service"})
public class ProjectConfig {
}
