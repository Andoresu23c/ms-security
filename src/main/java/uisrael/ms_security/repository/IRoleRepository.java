package uisrael.ms_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uisrael.ms_security.model.Role;

public interface IRoleRepository extends JpaRepository<Role, Integer> {
}
