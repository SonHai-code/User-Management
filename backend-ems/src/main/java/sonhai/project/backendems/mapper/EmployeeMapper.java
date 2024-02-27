package sonhai.project.backendems.mapper;

import sonhai.project.backendems.dto.EmployeeDto;
import sonhai.project.backendems.entity.Employee;

/**
 *
 * Store functions that convert Employee to EmployeeDto and vice versa.
 *
 *
 * */
public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(employee.getId(),
                            employee.getFirstName(),
                            employee.getLastName(),
                            employee.getEmail());
    }

    public static Employee maptoEmployee(EmployeeDto employeeDto) {
        return new Employee(employeeDto.getId(),
                        employeeDto.getFirstName(),
                        employeeDto.getLastName(),
                        employeeDto.getEmail());
    }



}
