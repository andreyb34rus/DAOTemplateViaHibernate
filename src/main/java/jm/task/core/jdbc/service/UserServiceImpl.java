package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    public void createUsersTable() {
        new UserDaoHibernateImpl().createUsersTable();
    }

    public void dropUsersTable() {
        new UserDaoHibernateImpl().dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        new UserDaoHibernateImpl().saveUser(name, lastName, age);
        System.out.printf("User с именем – %s добавлен в базу данных.\n", name);
    }

    public void removeUserById(long id) {
        new UserDaoHibernateImpl().removeUserById(id);
    }

    public List<User> getAllUsers() {
        List<User> userList = new UserDaoHibernateImpl().getAllUsers();
        for (User user : userList) {
            System.out.println(user);
        }
        return userList;
    }

    public void cleanUsersTable() {
        new UserDaoHibernateImpl().cleanUsersTable();
    }
}
