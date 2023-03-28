package uz.dsk.docflow.resource.catalogs;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.dsk.docflow.models.catalogs.Personal;
import uz.dsk.docflow.service.catalogs.PersonalService;

import java.util.List;

@RestController
@RequestMapping("/doc/personal/")
@RequiredArgsConstructor
public class PersonalResource {

    private final PersonalService personalService;

    @GetMapping("get")
    private ResponseEntity<List<Personal>> getAll(){
        return ResponseEntity.ok().body(personalService.getAll());
    }

    @PostMapping("save")
    private ResponseEntity<Personal> save(@RequestBody Personal worker){
        return ResponseEntity.ok().body(personalService.save(worker));
    }

    @DeleteMapping("delete")
    private void delete(@RequestParam Long id){
        personalService.delete(id);
    }

}
