package uz.backweb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.backweb.models.Active;
import uz.backweb.models.Catalog;

import java.util.List;

@Repository
public interface CatalogRepo extends JpaRepository<Catalog, Long> {

    @Query("select c from Catalog c where c.active = :active")
    List<Catalog> getAllActive(@Param("active") Active activeObject);
}
