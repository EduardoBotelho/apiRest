package ApiRest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDb {

    private static final Logger log = LoggerFactory.getLogger(LoadDb.class);
    // persistindo dados no banco com jpa
    @Bean
    CommandLineRunner applicationRunner(EmployeeRepository employeerepository){
        return args -> {
            log.info( "Log of event save user 1: " + employeerepository.save(new Employee("Maria Silva","Chef",
                    "avenida silveira dutra 1002")));
            log.info("log of event save user 2:" + employeerepository.save(new Employee("John Dutra","Mecanico",
                    "rua joao freire 231")));
        };
    }
}