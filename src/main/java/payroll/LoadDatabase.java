package payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// This tells Spring Boot 'Hey, this class has configurations you need to use'
@Configuration
class LoadDatabase {

    // Create a new logger for printing log messages to the console
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    // Tells Spring Boot that this method should run at startup
    // Bean is used for registering Spring-managed methods that run automatically
    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Employee("Virgil Hawkins", "Hero")));
            log.info("Preloading " + repository.save(new Employee("Frodo Bagginns", "Thief")));
        };
    }
}
