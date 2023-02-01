package uz.dsk.docflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.dsk.docflow.models.Position;

public interface PositionRepository extends JpaRepository<Position, Long> {
}
