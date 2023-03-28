package uz.dsk.docflow.repository.documents;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.dsk.docflow.models.documents.ItemOrder;

public interface ItemOrderRepository extends JpaRepository<ItemOrder, Long> {
}