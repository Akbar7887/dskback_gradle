package uz.backweb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.backweb.models.jobs.ItemJob;

public interface JobItemRepo extends JpaRepository<ItemJob, Long> {
}
