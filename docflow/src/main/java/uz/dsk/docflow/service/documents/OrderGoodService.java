package uz.dsk.docflow.service.documents;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uz.dsk.docflow.models.documents.ItemOrder;
import uz.dsk.docflow.models.documents.OrderGood;
import uz.dsk.docflow.models.others.ACTIVE;
import uz.dsk.docflow.repository.documents.ItemOrderRepository;
import uz.dsk.docflow.repository.documents.OrderGoodRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class OrderGoodService {

    private final OrderGoodRepository orderGoodsRepository;
    private final ItemOrderRepository itemOrderRepository;

    public List<OrderGood> getAllActive() {
        return orderGoodsRepository.getAllActive(ACTIVE.ACTIVE);
    }

    public OrderGood save(OrderGood orderGoods) {
        return orderGoodsRepository.save(orderGoods);
    }

    public OrderGood delete(Long id) {
        OrderGood orderGoods = orderGoodsRepository.getById(id);
        orderGoods.setActive(ACTIVE.NOACTIVE);
        return orderGoodsRepository.save(orderGoods);
    }

    public List<ItemOrder> addItem(Long id, List<ItemOrder> itemOrder) {
//        ItemOreder itemOreder1 = itemOrederRepository.save(itemOreder);
        OrderGood orderGoods = orderGoodsRepository.findById(id).orElse(null);

        for (ItemOrder item: itemOrder){
            if (item.getId() != null){
                itemOrderRepository.save(item);
            }else {
                orderGoods.addItem(item);
                orderGoodsRepository.save(orderGoods);
            }
        }

        return orderGoods.getItemOrders();
    }

    public ItemOrder editItem(ItemOrder itemOreder){
       return  itemOrderRepository.save(itemOreder);
    }
}
