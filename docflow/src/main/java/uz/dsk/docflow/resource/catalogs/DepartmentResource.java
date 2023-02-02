package uz.dsk.docflow.resource.catalogs;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.dsk.docflow.models.catalogs.Department;
import uz.dsk.docflow.service.catalogs.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/doc/department/")
@RequiredArgsConstructor
public class DepartmentResource {

    private final DepartmentService departmentService;

    @GetMapping("get")
    private ResponseEntity<List<Department>> getAll(){

        return ResponseEntity.ok().body(departmentService.getAll());
    }

    @PostMapping("save")
    private ResponseEntity<Department> save(@RequestBody Department department){

        return ResponseEntity.ok().body(departmentService.save(department));
    }

    @DeleteMapping("delete")
    private void delete(@RequestParam  Long id){
        departmentService.delete(id);
    }
}
