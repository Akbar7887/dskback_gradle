package uz.dsk.docflow.repository.catalogs;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.dsk.docflow.models.catalogs.Personal;

public interface PersonalRepository extends JpaRepository<Personal, Long> {
}
