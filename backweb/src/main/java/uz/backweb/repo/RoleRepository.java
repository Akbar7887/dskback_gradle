package uz.backweb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.backweb.models.auth.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByname(String name);
}
