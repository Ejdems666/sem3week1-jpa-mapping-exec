package entity;

import javax.persistence.*;

/**
 * Created by adam on 23/08/2017.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class DiscountType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    abstract double calculateDiscount(double pricePerItem, int quantity);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
