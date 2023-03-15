package uz.dsk.docflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.dsk.docflow.models.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

//    @Query(value = "SELECT  o.id FROM Organization o ORDER BY o.id LIMIT 1", nativeQuery = true)
//    Organization getFirst();

}