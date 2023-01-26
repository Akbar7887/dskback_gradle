package uz.backweb.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.backweb.models.Dom;
import uz.backweb.sevice.DomService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dom/")
public class DomResource {

    private final DomService domService;

    @GetMapping("get")
    private List<Dom> getAllDobByIdKompleks(@RequestParam(value = "id") String id){
        return domService.getDomByIdKompleks(id);
    }

    @PostMapping("save")
    private ResponseEntity<Dom> postDom(@RequestBody  Dom dom, @RequestParam(value = "id") String id){
        return ResponseEntity.ok().body(domService.saveDom(dom, id));
    }

    @PostMapping("remove")
    private ResponseEntity<Dom> deleteDom(@RequestParam("id") String id){
        return ResponseEntity.ok().body(domService.deleteDom(id));
    }
}
