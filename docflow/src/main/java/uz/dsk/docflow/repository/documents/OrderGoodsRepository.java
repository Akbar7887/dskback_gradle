package uz.dsk.docflow.repository.documents;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.dsk.docflow.models.documents.OrderGoods;
import uz.dsk.docflow.models.others.ACTIVE;

import java.util.List;

public interface OrderGoodsRepository extends JpaRepository<OrderGoods, Long> {

    @Query("select o from OrderGoods o where o.active = :active")
    List<OrderGoods> getAllActive(@Param("active") ACTIVE active);
}