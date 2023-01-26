package uz.dsk.api_gateway.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.dsk.api_gateway.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByname(String name);
}
