package uz.dsk.docflow.repository.documents;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.dsk.docflow.models.documents.OrderGood;
import uz.dsk.docflow.models.others.ACTIVE;

import java.util.List;

public interface OrderGoodRepository extends JpaRepository<OrderGood, Long> {

    @Query("select o from OrderGood o where o.active = :active")
    List<OrderGood> getAllActive(@Param("active") ACTIVE active);
}