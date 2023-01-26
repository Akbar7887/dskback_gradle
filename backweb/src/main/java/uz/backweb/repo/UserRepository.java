package uz.backweb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.backweb.models.auth.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUsername(String username);
}
