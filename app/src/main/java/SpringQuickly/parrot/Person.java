package SpringQuickly.parrot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name;
    private final ParrotForHuman parrot;

    @Autowired
    Person(ParrotForHuman parrot) {
        this.parrot = parrot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ParrotForHuman getParrot() {
        return parrot;
    }

}