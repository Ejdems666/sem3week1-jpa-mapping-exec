import entity.DiscountQuantity;
import entity.FixedDiscount;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by adam on 23/08/2017.
 */
public class DiscountTypeTester {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("week1jpaPersistanceUnit");
        EntityManager em = entityManagerFactory.createEntityManager();

        FixedDiscount discount = new FixedDiscount();
        discount.setDiscount(0.1);

        DiscountQuantity discountQuantity= new DiscountQuantity();
        discountQuantity.setDiscount(0.2);
        discountQuantity.setQuantityForDiscount(3);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(discount);
        em.persist(discountQuantity);
        em.flush();
        transaction.commit();
    }
}
