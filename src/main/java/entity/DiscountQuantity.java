package entity;

import javax.persistence.Entity;

/**
 * Created by adam on 23/08/2017.
 */
@Entity
public class DiscountQuantity extends DiscountType{
    int quantityForDiscount;
    double discount;

    public int getQuantityForDiscount() {
        return quantityForDiscount;
    }

    public void setQuantityForDiscount(int quantityForDiscount) {
        this.quantityForDiscount = quantityForDiscount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public double calculateDiscount(double pricePerItem, int quantity) {
        double price = pricePerItem * quantity;
        if (pricePerItem > 3) {
            return price * discount;
        }
        return 0;
    }
}
