package uz.backweb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.backweb.models.Active;
import uz.backweb.models.Orderb;

import java.util.List;

public interface OrderRepo extends JpaRepository<Orderb, Long> {

    @Query("select o from orderb o where o.active =:active")
    List<Orderb> getAll(@Param("active") Active active);
}
