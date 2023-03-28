package uz.dsk.docflow.models.documents;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "itemorder")
public class ItemOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double quantity;

    @ManyToOne()
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @JsonBackReference
    @ToString.Exclude
    private OrderGood order;

    public ItemOrder() {
    }

    public ItemOrder(Long id, String name, double quantity, OrderGood order) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public OrderGood getOrder() {
        return order;
    }

    public void setOrder(OrderGood order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ItemOrder itemOrder = (ItemOrder) o;
        return id != null && Objects.equals(id, itemOrder.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


}
