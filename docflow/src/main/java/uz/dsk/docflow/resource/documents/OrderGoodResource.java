package uz.dsk.docflow.resource.documents;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.dsk.docflow.models.documents.OrderGood;
import uz.dsk.docflow.service.documents.OrderGoodService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/doc/ordergoods/")
public class OrderGoodResource {

    @Autowired
    private final OrderGoodService orderGoodsService;

    @GetMapping("get")
    private ResponseEntity<List<OrderGood>> getAllActive() {

        return ResponseEntity.ok().body(orderGoodsService.getAllActive());
    }

    @PostMapping("save")
    private OrderGood save(@RequestBody OrderGood orderGoods) {
        return orderGoodsService.save(orderGoods);
    }

    @PostMapping("delete")
    private ResponseEntity<OrderGood> delete(@RequestParam String id) {
        return ResponseEntity.ok().body(orderGoodsService.delete(Long.parseLong(id)));
    }

//    @PostMapping("additem")
//    public ResponseEntity<List<ItemOrder>> addItem(@RequestParam("order_id") String order_id, @RequestBody List<ItemOrder> itemOrder) {
//        return ResponseEntity.ok().body(orderGoodsService.addItem(Long.parseLong(order_id), itemOrder));
//    }
//
//    @PutMapping("edititem")
//    public ResponseEntity<ItemOrder> editItem(@RequestBody ItemOrder itemOrder){
//        return ResponseEntity.ok().body(orderGoodsService.editItem(itemOrder));
//    }

}
