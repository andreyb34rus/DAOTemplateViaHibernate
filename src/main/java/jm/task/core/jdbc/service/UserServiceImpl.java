package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    public void createUsersTable() {
        new UserDaoJDBCImpl().createUsersTable();
    }

    public void dropUsersTable() {
        new UserDaoJDBCImpl().dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        new UserDaoJDBCImpl().saveUser(name, lastName, age);
        System.out.printf("User с именем – %s добавлен в базу данных.\n", name);
    }

    public void removeUserById(long id) {
        new UserDaoJDBCImpl().removeUserById(id);
    }

    public List<User> getAllUsers() {
        List<User> userList = new UserDaoJDBCImpl().getAllUsers();
        for (User user : userList) {
            System.out.println(user);
        }
        return userList;
    }

    public void cleanUsersTable() {
        new UserDaoJDBCImpl().cleanUsersTable();
    }
}
