package sonhai.project.backendems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sonhai.project.backendems.models.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
