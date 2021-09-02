package ru.jm.service;

import ru.jm.model.Role;

import java.util.List;

public interface RoleService  {

    List<Role> allRole();//все роли

    void changeRole(Role role);//изменить

    void removeRole(Role role);//удалить роль

    Role addRole(Role role);//создать роль

    Role findById(Long id);
}
