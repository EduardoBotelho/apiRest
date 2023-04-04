package ApiRest;

import br.com.exemploRDS.apiRest.Person;
import br.com.exemploRDS.apiRest.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDB {

    private static final Logger log = LoggerFactory.getLogger(LoadDB.class);
    @Bean
    public CommandLineRunner commandLineRunner(EmployeeRepository employeerepository){
        return args -> {
            log.info("Log of event save user 1: " +employeerepository.save(new Employee("Patricia",
                    "Funcionario","Avenida Atlantica,3456")));
           log.info("Log of event save user 2: "+employeerepository.save(new Employee("John",
                   "","Rua Faria Lima, 900")));
        };
    }
}
