package uz.dsk.docflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.dsk.docflow.models.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
