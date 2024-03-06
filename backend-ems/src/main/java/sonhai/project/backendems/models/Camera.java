package sonhai.project.backendems.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cameras")
public class Camera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;

    private List<String> imagesSource;

    @ManyToMany(mappedBy = "cameras")
    @EqualsAndHashCode.Exclude
    private List<Employee> employees;

    @ManyToMany(mappedBy = "cameras")
    @EqualsAndHashCode.Exclude
    private List<Guess> guesses;

}