package sonhai.project.backendems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sonhai.project.backendems.enums.ERole;
import sonhai.project.backendems.models.Role;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
