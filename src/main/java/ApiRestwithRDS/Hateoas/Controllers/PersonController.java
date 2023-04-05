package ApiRestwithRDS.Hateoas.Controllers;

import ApiRestwithRDS.Entitys.OrderHateoas;
import ApiRestwithRDS.Repositories.OrderRepositoryHateoas;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    private final OrderRepositoryHateoas orderRepositoryHateoas;

    public PersonController(OrderRepositoryHateoas personRepository) {
        this.orderRepositoryHateoas = personRepository;
    }



    //metodos de requisicao
    @GetMapping("/persons")
    public List<OrderHateoas> consulta(){
        return  orderRepositoryHateoas.findAll();
    }

    @GetMapping("/persons/{id}")
    public Optional<OrderHateoas> consultaPorId(@PathVariable Long id){
        return orderRepositoryHateoas.findById(id);
    }

}
