package uz.backweb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.backweb.models.Active;
import uz.backweb.models.News;

import java.util.List;

@Repository
public interface NewsRepo extends JpaRepository<News, Long> {

    @Query("select n from News n  where n.active=:active ")
    List<News> getAllActive(@Param("active") Active active);
}
