package uisrael.ms_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uisrael.ms_security.model.Profile;

public interface IProfileRepository extends JpaRepository<Profile, Integer> {
}
