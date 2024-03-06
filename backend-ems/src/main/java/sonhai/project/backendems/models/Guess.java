package sonhai.project.backendems.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "guesses")
public class Guess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "attending_time")
    private LocalDateTime attendingTime;

    @Column(name = "leaving_time")
    private LocalDateTime leavingTime;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinTable(name = "guess_camera",
    joinColumns = @JoinColumn(name = "guess_id"),
    inverseJoinColumns = @JoinColumn(name = "camera_id"))
    private List<Camera> cameras;


}
