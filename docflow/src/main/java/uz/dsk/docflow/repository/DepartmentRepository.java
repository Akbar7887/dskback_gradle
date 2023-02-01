package uz.dsk.docflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.dsk.docflow.models.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
