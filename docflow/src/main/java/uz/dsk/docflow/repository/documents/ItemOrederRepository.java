package uz.dsk.docflow.repository.documents;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.dsk.docflow.models.documents.ItemOreder;

public interface ItemOrederRepository extends JpaRepository<ItemOreder, Long> {
}