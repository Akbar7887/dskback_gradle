package uz.dsk.docflow.repository.catalogs;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.dsk.docflow.models.catalogs.Position;

public interface PositionRepository extends JpaRepository<Position, Long> {
}
