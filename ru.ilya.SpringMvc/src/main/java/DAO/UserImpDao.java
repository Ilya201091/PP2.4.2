package DAO;

import model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserImpDao implements UserDAO {

    @PersistenceContext(unitName = "emf")
    EntityManager entityManager;


    @Override
    public List<User> allUser() {
        return entityManager.createQuery(
                        "SELECT u FROM list_users u", User.class).getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void edit(User user) {
        User editUser = entityManager.merge(user);
        user.setUser(editUser);
    }

    @Override
    public User getById(long id) {
        return entityManager.find(User.class, id);
    }
}
