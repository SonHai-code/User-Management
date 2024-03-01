package sonhai.project.backendems.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import sonhai.project.backendems.entity.Camera;
import sonhai.project.backendems.entity.Department;
import sonhai.project.backendems.entity.TimeKeeping;

import java.util.List;

@Data
@AllArgsConstructor
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String gender;
    private String dob;
    private String address;
    private String phoneNumber;
    private Department department;
    private TimeKeeping timeKeeping;
    private String role;
    private List<Camera> cameras;
    private List<String> images;
}
