package uz.dsk.docflow;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uz.dsk.docflow.models.documents.ItemOreder;
import uz.dsk.docflow.resource.documents.OrderGoodsResource;

@SpringBootTest
class DocflowApplicationTests {

    @Autowired
    OrderGoodsResource orderGoodsResource;

    @Test
     void  contextLoads() {
        ItemOreder itemOreder = new ItemOreder();
        itemOreder.setName("ejfgerg");
        itemOreder.setQuantity(424.245);
        orderGoodsResource.addItem("10000", itemOreder);

    }



}
