package uz.dsk.docflow.models.documents;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import uz.dsk.docflow.models.catalogs.Warehouse;
import uz.dsk.docflow.models.catalogs.Worker;
import uz.dsk.docflow.models.others.ACTIVE;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ordergoods")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderGoods {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_id")
    @SequenceGenerator(name = "order_id", allocationSize = 5, initialValue = 10000)
    private Long id;

    @CreationTimestamp
    private Date datecreat;

    @OneToOne()
    private Worker worker;

    private boolean edit = false;

    @Column(name = "recievedate")
    private Date recieveDate;

    @OneToOne()
    private Warehouse warehouse;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ItemOreder> itemOrederList;

    @Enumerated(EnumType.STRING)
    private ACTIVE active = ACTIVE.ACTIVE;



}
