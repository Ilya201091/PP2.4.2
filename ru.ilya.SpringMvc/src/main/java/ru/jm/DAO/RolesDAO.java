package ru.jm.DAO;



import ru.jm.model.Role;


import java.util.List;


public interface RolesDAO {

    List<Role> allRole();//все роли

    void changeRole(Role role);//изменить

    void removeRole(Role role);//удалить роль

    void addRole(Role role);//создать роль

}

