package ru.jm.DAO;

import ru.jm.model.Role;
import ru.jm.model.User;

import java.util.List;

public interface UserDAO {
    List<User> allUser(); //все юзеры
    void add(User user); // добавить юзера
  /*  void edit(User user); // изменить юзера*/
    User getById(long id); // выгрузить Юзера по id
    void update(User user); //изменить юзера
    void remove(long id); //удалить по id
    User getUserByName(String name); //выгрузить сущность юзера по имени
    Role getRole(String role); //установка роли
}
