package sonhai.project.backendems.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sonhai.project.backendems.dto.EmployeeDto;
import sonhai.project.backendems.entity.Employee;
import sonhai.project.backendems.mapper.EmployeeMapper;
import sonhai.project.backendems.repository.EmployeeRepository;
import sonhai.project.backendems.service.EmployeeService;

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
}
