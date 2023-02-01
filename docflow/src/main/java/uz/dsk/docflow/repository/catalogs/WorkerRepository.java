package uz.dsk.docflow.repository.catalogs;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.dsk.docflow.models.catalogs.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
