package sonhai.project.backendems.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import sonhai.project.backendems.enums.ERole;
@Data
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    public Role(ERole name) {
        this.name = name;
    }
}
