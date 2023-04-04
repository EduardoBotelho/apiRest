package br.com.exemploRDS.apiRest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }



    //metodos de requisicao
    @GetMapping("/persons")
    public List<Person> consulta(){
        return  personRepository.findAll();
    }

    @GetMapping("/persons/{id}")
    public Optional<Person> consultaPorId(@PathVariable Long id){
        return personRepository.findById(id);
    }

}
