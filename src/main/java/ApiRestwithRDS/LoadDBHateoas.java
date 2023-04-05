package ApiRestwithRDS;

import ApiRestwithRDS.Entitys.Employee;
import ApiRestwithRDS.Entitys.OrderHateoas;
import ApiRestwithRDS.Entitys.Status;
import ApiRestwithRDS.Repositories.EmployeeRepositoryHateoas;
import ApiRestwithRDS.Repositories.OrderRepositoryHateoas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDBHateoas {

    private static final Logger log = LoggerFactory.getLogger(LoadDBHateoas.class);
    @Bean
    public CommandLineRunner commandLineRunner(EmployeeRepositoryHateoas employeerepository){
        return args -> {
            log.info("Log of event save user 1: " +employeerepository.save(new Employee("Patricia",
                    "Funcionario","Avenida Atlantica,3456")));
           log.info("Log of event save user 2: "+employeerepository.save(new Employee("John",
                   "","Rua Faria Lima, 900")));
        };
    }

    @Autowired
    CommandLineRunner loadOrder(OrderRepositoryHateoas orderRepositoryHateoas){
        return args -> {
            orderRepositoryHateoas.save(new OrderHateoas(Status.COMPLETED,"review"));
            orderRepositoryHateoas.save(new OrderHateoas(Status.IN_PROGRESS,"travel"));
            orderRepositoryHateoas.save(new OrderHateoas(Status.IN_PROGRESS,"sale"));
            orderRepositoryHateoas.findAll().forEach(order -> {
                log.info("Preload " + order);
            });
        };
    }
}
