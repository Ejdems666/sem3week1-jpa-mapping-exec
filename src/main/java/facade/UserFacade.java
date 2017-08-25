package facade;

import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by adam on 22/08/2017.
 */
public class UserFacade {
    private EntityManager em;

    public UserFacade(EntityManager em) {
        this.em = em;
    }

    public User getUser(Long id) {
        return em.find(User.class, id);
    }

    public List<User> getAllUsers() {
        Query query = em.createQuery("SELECT u FROM User u");
        return query.getResultList();
    }

    public void saveUser(User user) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(user);
        em.flush();
        transaction.commit();
    }

    public void removeUser(Long id) throws Exception {
        User user = getUser(id);
        if (user == null) {
            throw new Exception("Non existent User with id: " + id);
        }
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(user);
        em.flush();
        transaction.commit();
    }
}
