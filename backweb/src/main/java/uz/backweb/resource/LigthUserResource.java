package uz.backweb.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.backweb.models.LigthUser;
import uz.backweb.sevice.LigthUserService;

import java.util.List;

@RestController
@RequestMapping("/api/ligthuser/")
@RequiredArgsConstructor
public class LigthUserResource {

    @Autowired
    final LigthUserService ligthUserService;

    @GetMapping("get")
    private ResponseEntity<List<LigthUser>> getAll(){
        return ResponseEntity.ok().body(ligthUserService.getAll());
    }

    @PostMapping("save")
    private ResponseEntity<LigthUser> save(@RequestBody LigthUser ligthUser){
        return ResponseEntity.ok().body(ligthUserService.save(ligthUser));
    }
}
