package sonhai.project.backendems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sonhai.project.backendems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
