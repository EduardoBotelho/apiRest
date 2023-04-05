package ApiRestwithRDS.Repositories;

import ApiRestwithRDS.Entitys.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepositoryHateoas extends JpaRepository<Employee, Long> {
}
