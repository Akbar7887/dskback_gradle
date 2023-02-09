package uz.dsk.docflow.resource.documents;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.dsk.docflow.models.documents.OrderGoods;
import uz.dsk.docflow.service.documents.OrderGoodsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/doc/ordergoods/")
public class OrderGoodsResource {

    private final OrderGoodsService orderGoodsService;

    @GetMapping("get")
    private ResponseEntity<List<OrderGoods>> getAllActive() {

        return ResponseEntity.ok().body(orderGoodsService.getAllActive());
    }

    @PostMapping("save")
    private ResponseEntity<OrderGoods> save(@RequestBody OrderGoods orderGoods) {
        return ResponseEntity.ok().body(orderGoodsService.save(orderGoods));
    }

    @PostMapping("delete")
    private ResponseEntity<OrderGoods> delete(@RequestParam String id) {
        return ResponseEntity.ok().body(orderGoodsService.delete(Long.parseLong(id)));
    }
}
