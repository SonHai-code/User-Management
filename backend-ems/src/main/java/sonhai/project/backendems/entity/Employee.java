package sonhai.project.backendems.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    /* Not accepting null values */
    @Column(name = "email_id", nullable = false, unique = true)
    private String email;

    private String gender;

    @Column(name = "date_of_birth")
    private String dob;

    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "department_id") // Foreign Key "department_id"
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Department department;

    @Transient
    public boolean isManager() {
        return department != null && department.getManager() == this;
    }
    private String role;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinTable(name = "employee_camera",
    joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "camera_")
    )
    private List<Camera> cameras;

}
