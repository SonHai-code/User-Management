package sonhai.project.backendems.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table()
public class TimeKeeping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate day;

    private  static final LocalTime APPROPRIATE_TIME = LocalTime.parse("08:30:00");

    @Column(name = "clock_in")
    private LocalTime clockIn;

    @Column(name = "clock_out")
    private LocalTime clockOut;

    @Column(name = "early_minutes")
    private Long earlyMinutes;

    @Column(name = "late_minutes")
    private Long lateMinutes;

    @Column(name = "total_worked_hours")
    private Long totalWorkedHours;

    @OneToMany(mappedBy = "timeKeeping", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Employee> employees;



}
