package uz.dsk.docflow.service.documents;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uz.dsk.docflow.models.documents.ItemOreder;
import uz.dsk.docflow.models.documents.OrderGood;
import uz.dsk.docflow.models.others.ACTIVE;
import uz.dsk.docflow.repository.documents.ItemOrederRepository;
import uz.dsk.docflow.repository.documents.OrderGoodRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class OrderGoodService {

    private final OrderGoodRepository orderGoodsRepository;
    private final ItemOrederRepository itemOrederRepository;

    public List<OrderGood> getAllActive() {
        return orderGoodsRepository.getAllActive(ACTIVE.ACTIVE);
    }

    public OrderGood save(OrderGood orderGoods) {
        return orderGoodsRepository.save(orderGoods);
    }

    public OrderGood delete(Long id) {
        OrderGood orderGoods = orderGoodsRepository.getById(id);
        if (orderGoods != null) {
            orderGoods.setActive(ACTIVE.NOACTIVE);
        }
        return orderGoodsRepository.save(orderGoods);
    }

    public List<ItemOreder> addItem(Long id, List<ItemOreder> itemOreder) {
//        ItemOreder itemOreder1 = itemOrederRepository.save(itemOreder);
        OrderGood orderGoods = orderGoodsRepository.findById(id).orElse(null);

        for (ItemOreder item: itemOreder){
            if (item.getId() != null){
                itemOrederRepository.save(item);
            }else {
                orderGoods.addItem(item);
                orderGoodsRepository.save(orderGoods);
            }
        }

        return orderGoods.getItemOreders();
    }

    public ItemOreder editItem(ItemOreder itemOreder){
       return  itemOrederRepository.save(itemOreder);
    }
}
