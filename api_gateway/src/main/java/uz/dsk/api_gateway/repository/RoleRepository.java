package uz.dsk.api_gateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.dsk.api_gateway.models.auth.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByname(String name);
}
