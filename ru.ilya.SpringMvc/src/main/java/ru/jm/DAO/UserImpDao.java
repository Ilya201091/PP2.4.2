package ru.jm.DAO;

import ru.jm.model.Role;
import ru.jm.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserImpDao implements UserDAO {

    @PersistenceContext()
    EntityManager entityManager;


    @Override
    public List<User> allUser() {
        return entityManager.createQuery(
                "from User ", User.class).getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

  /*  @Override
    public void edit(User user) {
          entityManager.merge(user);
    }*/

    @Override
    public User getById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(long id,User user) {
        User newUser = getById(id);
        newUser.setFirstName(user.getFirstName());
        newUser.setEmail(user.getEmail());
        newUser.setAge(user.getAge());
    }

    @Override
    public void remove(long id) {
        User user = getById(id);
        if (user != null) {
            entityManager.remove(user);
        } else {
            System.out.println("There is no such user");
        }
    }

    @Override
    public User getUserByName(String name) {
        return entityManager.createQuery("SELECT u FROM User u WHERE u.firstName = '"+ name +"'", User.class).getSingleResult();
    }

    @Override
    public Role getRole(String role) {
        return entityManager.createQuery ("SELECT u FROM Role u WHERE u.roleName = '"+ role +"'", Role.class).getSingleResult();
    }


}
