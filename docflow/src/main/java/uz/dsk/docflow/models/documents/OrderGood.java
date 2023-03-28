package uz.dsk.docflow.models.documents;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import uz.dsk.docflow.models.catalogs.Personal;
import uz.dsk.docflow.models.catalogs.Warehouse;
import uz.dsk.docflow.models.others.ACTIVE;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ordergood")
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
    private List<ItemOrder> itemOrders;

    @Enumerated(EnumType.STRING)
    private ACTIVE active = ACTIVE.ACTIVE;


    public void addItem(ItemOrder itemOrder) {
        if (!this.itemOrders.contains(itemOrder)) {
            this.itemOrders.add(itemOrder);
            itemOrder.setOrder(this);
        }
    }

    public OrderGood() {
    }

    public OrderGood(Long id, Date datecreate, Personal worker, boolean edit, Date recieveDate, Warehouse warehouse, List<ItemOrder> itemOrders, ACTIVE active) {
        this.id = id;
        this.datecreate = datecreate;
        this.worker = worker;
        this.edit = edit;
        this.recieveDate = recieveDate;
        this.warehouse = warehouse;
        this.itemOrders = itemOrders;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatecreate() {
        return datecreate;
    }

    public void setDatecreate(Date datecreate) {
        this.datecreate = datecreate;
    }

    public Personal getWorker() {
        return worker;
    }

    public void setWorker(Personal worker) {
        this.worker = worker;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public Date getRecieveDate() {
        return recieveDate;
    }

    public void setRecieveDate(Date recieveDate) {
        this.recieveDate = recieveDate;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public List<ItemOrder> getItemOrders() {
        return itemOrders;
    }

    public void setItemOrders(List<ItemOrder> itemOrders) {
        this.itemOrders = itemOrders;
    }

    public ACTIVE getActive() {
        return active;
    }

    public void setActive(ACTIVE active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrderGood orderGood = (OrderGood) o;
        return id != null && Objects.equals(id, orderGood.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
