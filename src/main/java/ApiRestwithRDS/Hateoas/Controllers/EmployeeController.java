package ApiRestwithRDS.Hateoas.Controllers;

import ApiRestwithRDS.Entitys.Employee;
import ApiRestwithRDS.Exceptions.EmployeeNotFoundExceptionHateoas;
import ApiRestwithRDS.Repositories.EmployeeRepositoryHateoas;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeRepositoryHateoas repository;

    public EmployeeController(EmployeeRepositoryHateoas repository) {
        this.repository = repository;
    }

    @GetMapping("/employees")
    public List<Employee> listOfEmployeeAll(){
        return repository.findAll();
    }
    @GetMapping("/employees/{id}")
    public Employee consultById(@PathVariable Long id){
        return repository.findById(id).orElseThrow(()-> new EmployeeNotFoundExceptionHateoas(id));
    }

    @PostMapping("/employees")
    public Employee newEmployee(@RequestBody Employee newEmployee){
        return repository.save(newEmployee);
    }
    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, long id){
        return repository.findById(id).map(employee -> {
            employee.setName(new Employee().getName());
            employee.setAddress(new Employee().getAddress());
            employee.setRole(new Employee().getRole());
            return repository.save(newEmployee);
        }).orElseGet(() -> {
            newEmployee.setId(id);
            return repository.save(newEmployee);
        });
    }
    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable long id){
        repository.deleteById(id);
    }
}
