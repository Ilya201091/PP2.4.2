package ru.jm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.jm.DAO.RolesDAO;
import ru.jm.model.Role;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleServiceImplem implements RoleService {

    private final RolesDAO rolesDAO;

    @Autowired
    public RoleServiceImplem(RolesDAO rolesDAO) {
        this.rolesDAO = rolesDAO;
    }


    @Override
    public List<Role> allRole() {
        return rolesDAO.allRole();
    }

    @Override
    public void changeRole(Role role) {
        rolesDAO.changeRole(role);
    }

    @Override
    public void removeRole(Role role) {
        rolesDAO.removeRole(role);
    }

    @Override
    public void addRole(Role role) {
        rolesDAO.addRole(role);
    }
}
