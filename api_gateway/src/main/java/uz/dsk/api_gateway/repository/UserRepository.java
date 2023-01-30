package uz.dsk.api_gateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.dsk.api_gateway.models.auth.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUsername(String username);
}
