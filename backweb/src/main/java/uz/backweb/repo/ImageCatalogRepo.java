package uz.backweb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.backweb.models.ImageCatalog;

import java.util.List;

public interface ImageCatalogRepo extends JpaRepository<ImageCatalog, Long> {


    @Query("select i from ImageCatalog i where i.catalog.id =:id")
    List<ImageCatalog> findByCatalog_Id(@Param("id") Long id);

}
