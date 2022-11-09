package jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@Configuration
@EnableAutoConfiguration
public class CustomerApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(CustomerApp.class);
        CustomerRepo repository = ctx.getBean(CustomerRepo.class);

        repository.save(new Customer("Jack", "Bauer"));
        repository.save(new Customer("Chloe", "O'Brian"));
        repository.save(new Customer("Kim", "Bauer"));
        repository.save(new Customer("David", "Palmer"));
        repository.save(new Customer("Michelle", "Dessler"));

        Iterable<Customer> customerIterable = repository.findAll();
        System.out.println("Customers found by findAll()");
        System.out.println("-----------------------------");
        for(Customer customer : customerIterable) {
            System.out.println(customer);
        }

        // fetch an individual customer by ID
        Optional<Customer> customerOptional = repository.findById(1L);
        System.out.println("Customer found with findOne(1L):");
        System.out.println("--------------------------------");
        if (customerOptional.isPresent()) {
            System.out.println("Not found");
        }
        System.out.println();

        // fetch customers by last name
        List<Customer> bauers = repository.findByLastName("Bauer");
        System.out.println("Customer found with findByLastName('Bauer'):");
        System.out.println("--------------------------------------------");
        for (Customer bauer : bauers) {
            System.out.println(bauer);
        }

        ctx.close();
    }
}
