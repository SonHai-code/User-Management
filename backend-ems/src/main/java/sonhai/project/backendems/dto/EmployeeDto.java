package sonhai.project.backendems.dto;

import lombok.*;
import sonhai.project.backendems.models.Camera;
import sonhai.project.backendems.models.CheckInLog;
import sonhai.project.backendems.models.Department;
import sonhai.project.backendems.models.TimeKeeping;

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
    private List<CheckInLog> checkInLogs;
}
