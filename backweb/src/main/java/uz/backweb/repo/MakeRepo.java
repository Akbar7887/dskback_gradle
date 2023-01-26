package uz.backweb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.backweb.models.Make;

@Repository
public interface MakeRepo extends JpaRepository<Make, Long> {

}
