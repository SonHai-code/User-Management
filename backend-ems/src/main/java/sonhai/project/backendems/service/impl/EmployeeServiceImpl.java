package sonhai.project.backendems.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sonhai.project.backendems.dto.EmployeeDto;
import sonhai.project.backendems.entity.Employee;
import sonhai.project.backendems.exception.ResourceNotFoundException;
import sonhai.project.backendems.mapper.EmployeeMapper;
import sonhai.project.backendems.repository.EmployeeRepository;
import sonhai.project.backendems.service.EmployeeService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.maptoEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                                .orElseThrow(()-> new ResourceNotFoundException("Cannot found the employee with the id : " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(employee -> EmployeeMapper.mapToEmployeeDto(employee))
                        .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployeeById(Long employeeId, EmployeeDto updatingEmployee) {
        /* Find the employee with the given ID */
        Employee employee = employeeRepository.findById(employeeId)
                                                .orElseThrow(() -> new ResourceNotFoundException("Cannot found the employee with the id: " + employeeId));

        /* Update the employee */
        if (!updatingEmployee.getFirstName().isEmpty()) {
            employee.setFirstName(updatingEmployee.getFirstName());
        }

        if (!updatingEmployee.getMiddleName().isEmpty()) {
            employee.setMiddleName(updatingEmployee.getMiddleName());
        }

        if (!updatingEmployee.getLastName().isEmpty()) {
            employee.setLastName(updatingEmployee.getLastName());
        }

        if (!updatingEmployee.getEmail().isEmpty()) {
            employee.setEmail(updatingEmployee.getEmail());
        }

        if (!updatingEmployee.getGender().isEmpty()) {
            employee.setGender(updatingEmployee.getGender());
        }

        if (!updatingEmployee.getDob().isEmpty()) {
            employee.setDob(updatingEmployee.getDob());
        }

        if (!updatingEmployee.getAddress().isEmpty()) {
            employee.setAddress(updatingEmployee.getAddress());
        }

        if (!updatingEmployee.getPhoneNumber().isEmpty()) {
            employee.setPhoneNumber(updatingEmployee.getPhoneNumber());
        }

        /* Saving the employee to the database */
        Employee updatedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                                                .orElseThrow(() -> new ResourceNotFoundException("Cannot found the employee with the id: " + employeeId));

        employeeRepository.delete(employee);
    }
}
