package uz.dsk.docflow.models.documents;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import uz.dsk.docflow.models.catalogs.Warehouse;
import uz.dsk.docflow.models.catalogs.Personal;
import uz.dsk.docflow.models.others.ACTIVE;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ordergood")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderGood {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_id")
    @SequenceGenerator(name = "order_id", allocationSize = 5, initialValue = 10000)
    private Long id;

    @CreationTimestamp
    private Date datecreate;

    @OneToOne()
    private Personal worker;

    private boolean edit = false;

    @Column(name = "recievedate")
    private Date recieveDate;

    @OneToOne()
    private Warehouse warehouse;

    @OneToMany(mappedBy = "order",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ItemOreder> itemOreders;

    @Enumerated(EnumType.STRING)
    private ACTIVE active = ACTIVE.ACTIVE;


    public void addItem(ItemOreder itemOreder) {
        if (!this.itemOreders.contains(itemOreder)) {
            this.itemOreders.add(itemOreder);
            itemOreder.setOrder(this);
        }
    }


}
