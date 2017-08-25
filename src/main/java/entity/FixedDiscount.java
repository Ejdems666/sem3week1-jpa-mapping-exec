package entity;

import javax.persistence.Entity;

/**
 * Created by adam on 23/08/2017.
 */
@Entity
public class FixedDiscount extends DiscountType {
    double discount;

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public double calculateDiscount(double pricePerItem, int quantity) {
        return pricePerItem * quantity * discount;
    }
}
