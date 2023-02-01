package uz.dsk.docflow.repository.catalogs;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.dsk.docflow.models.catalogs.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
