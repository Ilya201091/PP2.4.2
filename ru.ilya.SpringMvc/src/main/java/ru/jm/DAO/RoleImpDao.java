package ru.jm.DAO;

import org.springframework.stereotype.Repository;
import ru.jm.model.Role;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class RoleImpDao implements RolesDAO{

    @PersistenceContext()
    EntityManager entityManager;

    @Override
    public List<Role> allRole() {//список ролей
        return entityManager.createQuery(
                "from Role").getResultList();
    }


    @Override
    public void changeRole(Role role) {//редактировать роль
        entityManager.merge(role);
    }//изменить роль




    @Override
    public void removeRole(Role role) {//удалить роль
        if(role == null) {
            System.out.println("This role does not exist");
        }
        entityManager.remove(role);
        System.out.println("role removed");
    }

    @Override
    public void addRole(Role role) {//создать роль
        entityManager.persist(role);
    }

    @Override
    public Role findRoleById(Long id) throws NoSuchElementException {
        return entityManager.find(Role.class,id);
    }
}
