package uz.dsk.docflow.service.catalogs;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.dsk.docflow.models.catalogs.Department;
import uz.dsk.docflow.repository.catalogs.DepartmentRepository;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public List<Department> getAll(){
       return departmentRepository.findAll();
    }

    public Department save(Department department){
        return departmentRepository.save(department);
    }

    public void delete(Long id){
        departmentRepository.deleteById(id);
    }
}
