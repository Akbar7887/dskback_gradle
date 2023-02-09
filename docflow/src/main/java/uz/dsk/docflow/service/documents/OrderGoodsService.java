package uz.dsk.docflow.service.documents;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uz.dsk.docflow.models.documents.ItemOreder;
import uz.dsk.docflow.models.documents.OrderGoods;
import uz.dsk.docflow.models.others.ACTIVE;
import uz.dsk.docflow.repository.documents.ItemOrederRepository;
import uz.dsk.docflow.repository.documents.OrderGoodsRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class OrderGoodsService {

    private final OrderGoodsRepository orderGoodsRepository;
    private final ItemOrederRepository itemOrederRepository;

    public List<OrderGoods> getAllActive() {
        return orderGoodsRepository.getAllActive(ACTIVE.ACTIVE);
    }

    public OrderGoods save(OrderGoods orderGoods) {
        return orderGoodsRepository.save(orderGoods);
    }

    public OrderGoods delete(Long id) {
        OrderGoods orderGoods = orderGoodsRepository.getById(id);
        if (orderGoods != null) {
            orderGoods.setActive(ACTIVE.NOACTIVE);
        }
        return orderGoodsRepository.save(orderGoods);
    }

    public OrderGoods addItem(Long id, ItemOreder itemOreder) {
        ItemOreder itemOreder1 = itemOrederRepository.save(itemOreder);
        Optional<OrderGoods> orderGoodsOptional = orderGoodsRepository.findById(id);
        OrderGoods orderGoods1 = orderGoodsOptional.get();
        orderGoods1.addItem(itemOreder1);
        orderGoodsRepository.save(orderGoods1);


        return orderGoods1;
    }
}
