package uz.backweb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.backweb.models.Active;
import uz.backweb.models.Meneger;

import java.util.List;

@Repository
public interface MenegerRepo extends JpaRepository<Meneger, Long> {

    @Query("select m from Meneger m where m.active =:active")
    List<Meneger> getAllActive(@Param("active") Active active);

}
