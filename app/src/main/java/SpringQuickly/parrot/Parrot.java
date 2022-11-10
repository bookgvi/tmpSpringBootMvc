package SpringQuickly.parrot;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Parrot {
    private String name;

    @PostConstruct
    public void init() {
        this.name = "Mikluho";
    }

    public Parrot parrot1() {
        Parrot p = new Parrot();
        p.setName("Mikki");
        return p;
    }

    public Parrot parrot2() {
        Parrot p = new Parrot();
        p.setName("Rikki");
        return p;
    }

    public Parrot parrot3() {
        Parrot p = new Parrot();
        p.setName("Tikki");
        return p;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
