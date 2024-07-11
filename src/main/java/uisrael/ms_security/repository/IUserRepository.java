package uisrael.ms_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uisrael.ms_security.model.User;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
