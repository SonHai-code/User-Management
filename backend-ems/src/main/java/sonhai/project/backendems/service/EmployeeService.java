package sonhai.project.backendems.service;

import sonhai.project.backendems.dto.EmployeeDto;
import sonhai.project.backendems.entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);
    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployeeById(Long employeeId, EmployeeDto updatingEmployee);

}
