package uz.backweb.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.backweb.models.Orderb;
import uz.backweb.sevice.OrderService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orderb/")
@RequiredArgsConstructor
public class OrderResource {

    @Autowired
    final OrderService orderService;

    @GetMapping("get")
    private ResponseEntity<List<Orderb>> get() {
        return ResponseEntity.ok().body(orderService.getallActive());
    }

    @PostMapping("save")
    private ResponseEntity<String> save(@RequestBody Map<String, Orderb>[] orderbs) {

        List<Orderb> list = new ArrayList<>();
        Arrays.stream(orderbs).map(orde -> list.add(orde.get("")));

        for (Orderb orderb : list) {
            orderService.save(orderb);
        }

        return ResponseEntity.ok().body("Ok");
    }
}
