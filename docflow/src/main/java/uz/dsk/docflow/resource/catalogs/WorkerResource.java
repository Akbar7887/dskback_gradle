package uz.dsk.docflow.resource.catalogs;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.dsk.docflow.models.catalogs.Worker;
import uz.dsk.docflow.service.catalogs.WorkerService;

import java.util.List;

@RestController
@RequestMapping("/doc/worker/")
@RequiredArgsConstructor
public class WorkerResource {

    private final WorkerService workerService;

    @GetMapping("get")
    private ResponseEntity<List<Worker>> getAll(){
        return ResponseEntity.ok().body(workerService.getAll());
    }

    @PostMapping("save")
    private ResponseEntity<Worker> save(@RequestBody  Worker worker){
        return ResponseEntity.ok().body(workerService.save(worker));
    }

    @DeleteMapping("delete")
    private void delete(@RequestParam Long id){
        workerService.delete(id);
    }

}
