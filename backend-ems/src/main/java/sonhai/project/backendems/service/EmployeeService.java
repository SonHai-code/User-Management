package sonhai.project.backendems.service;

import sonhai.project.backendems.dto.EmployeeDto;

public interface EmployeeService {
    /* Create new employee */
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);
}
