package SpringQuickly.parrot;

import SpringQuickly.parrot.AppConfig;
import SpringQuickly.parrot.Parrot;
import SpringQuickly.parrot.ParrotForHuman;
import SpringQuickly.parrot.Person;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        Parrot p1 = ctx.getBean(Parrot.class);
        System.out.println(p1.getName());

        ParrotForHuman ph = ctx.getBean(ParrotForHuman.class);
        Person person = ctx.getBean(Person.class);
        ph.setName("Mikki");
        person.setName("John");
        System.out.printf("Parrot: %s; Human: %s\n", ph, person.getName());
        System.out.printf("Person %s with %s\n", person.getName(), person.getParrot());
    }
}
