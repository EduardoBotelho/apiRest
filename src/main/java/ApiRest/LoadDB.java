package ApiRest;

import br.com.exemploRDS.apiRest.Person;
import br.com.exemploRDS.apiRest.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class LoadDB {

    @Bean
    public CommandLineRunner commandLineRunner(PersonRepository repository){
        return args -> {
            repository.save(new Person(1L,"Patricia","Maldonado"));
            repository.save(new Person(2L,"Natanael", "Brito"));

        };
    }
}
