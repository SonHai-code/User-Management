package sonhai.project.backendems.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.property.access.internal.PropertyAccessStrategyNoopImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "check_in_log")
public class CheckInLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;

    private LocalDate date;

    private LocalTime time;

    @Column(name = "inserted_time")
    private LocalTime insertedTime;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Employee employee;

}
