package uz.dsk.docflow.resource.catalogs;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.dsk.docflow.models.catalogs.Position;
import uz.dsk.docflow.service.catalogs.PositionService;

import java.util.List;

@RestController
@RequestMapping("/doc/position/")
@RequiredArgsConstructor
public class PositionResource {

    private final PositionService positionService;

    @GetMapping("get")
    private ResponseEntity<List<Position>> getAll() {
        return ResponseEntity.ok().body(positionService.getAll());
    }

    @PostMapping("save")
    private ResponseEntity<Position> save(@RequestBody Position position) {
        return ResponseEntity.ok().body(positionService.save(position));
    }

    @DeleteMapping("delete")
    private void delete(@RequestParam String id) {
        positionService.delete(Long.parseLong(id));
    }
}
