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
                            employee.getMiddleName(),
                            employee.getLastName(),
                            employee.getEmail(),
                            employee.getGender(),
                            employee.getDob(),
                            employee.getAddress(),
                            employee.getPhoneNumber(),
                            employee.getDepartment(),
                            employee.getTimeKeeping(),
                            employee.getRole(),
                            employee.getCameras(),
                            employee.getImages());
    }

    public static Employee maptoEmployee(EmployeeDto employeeDto) {
        return new Employee(employeeDto.getId(),
                        employeeDto.getFirstName(),
                        employeeDto.getMiddleName(),
                        employeeDto.getLastName(),
                        employeeDto.getEmail(),
                        employeeDto.getGender(),
                        employeeDto.getDob(),
                        employeeDto.getAddress(),
                        employeeDto.getPhoneNumber(),
                        employeeDto.getDepartment(),
                        employeeDto.getTimeKeeping(),
                        employeeDto.getRole(),
                        employeeDto.getCameras(),
                        employeeDto.getImages());
    }
}
