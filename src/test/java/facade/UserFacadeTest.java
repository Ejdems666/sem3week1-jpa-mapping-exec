package facade;

import entity.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by adam on 22/08/2017.
 */
public class UserFacadeTest {
    private UserFacade userFacade;
    private EntityManager em;

    public UserFacadeTest() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("week1jpaPersistanceUnit");
        em = entityManagerFactory.createEntityManager();
        userFacade = new UserFacade(em);
    }

    @Test(priority = 0)
    public void testSaveUser() throws Exception {
        User user = new User();
        user.setFirstName("Adam");
        userFacade.saveUser(user);
        Assert.assertTrue(user.getId() != null);
    }

    @Test(priority = 1)
    public void testGetUser() throws Exception {
        User user = userFacade.getUser(1l);
        Assert.assertEquals("Adam",user.getFirstName());
    }

    @Test(priority = 2)
    public void testGetAllUsers() throws Exception {
        List<User> users = userFacade.getAllUsers();
        User user = users.get(0);
        Assert.assertEquals("Adam",user.getFirstName());
    }


    @Test(priority = 5)
    public void testRemoveUser() throws Exception {
        userFacade.removeUser(1l);
        Assert.assertNull(userFacade.getUser(1l));
    }

    @Test(expectedExceptions = {Exception.class}, priority = 3)
    public void testNonexistentUser() throws Exception {
        userFacade.removeUser(2l);
    }

    @Test(priority = 4)
    public void testUpdateUser() {
        User user = userFacade.getUser(1l);
        String newName = "Lolz";
        user.setFirstName(newName);
        userFacade.saveUser(user);
        user = userFacade.getUser(1l);
        Assert.assertEquals(newName,user.getFirstName());
    }

    @Override
    protected void finalize() throws Throwable {
        em.close();
    }
}