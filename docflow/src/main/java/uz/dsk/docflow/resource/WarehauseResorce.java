package uz.dsk.docflow.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.dsk.docflow.models.Warehouse;
import uz.dsk.docflow.service.WarehouseService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/doc/warehouse/")
public class WarehauseResorce {

    private final WarehouseService warehouseService;

    @GetMapping("get")
    private ResponseEntity<List<Warehouse>> getAll(){
        return ResponseEntity.ok().body(warehouseService.getAll());
    }

    @PostMapping("save")
    private ResponseEntity<Warehouse> save(@RequestBody Warehouse warehouse){
        return ResponseEntity.ok().body(warehouseService.save(warehouse));
    }

    @DeleteMapping("delete")
    private void delete(@RequestParam String id){
        warehouseService.delete(Long.parseLong(id));
    }

}
