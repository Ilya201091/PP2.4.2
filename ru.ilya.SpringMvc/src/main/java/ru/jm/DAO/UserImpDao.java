package ru.jm.DAO;

import ru.jm.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    @Override
    public void edit(User user) {
      entityManager.merge(user);
    }

    @Override
    public User getById(long id) {
        return entityManager.find(User.class, id);
    }
}
