package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private static final UserDao USER_DAO = new UserDaoHibernateImpl();

    public void createUsersTable() {
        USER_DAO.createUsersTable();
    }

    public void dropUsersTable() {
        USER_DAO.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        USER_DAO.saveUser(name, lastName, age);
        System.out.printf("User с именем – %s добавлен в базу данных.\n", name);
    }

    public void removeUserById(long id) {
        new UserDaoHibernateImpl().removeUserById(id);
    }

    public List<User> getAllUsers() {
        List<User> userList = USER_DAO.getAllUsers();
        for (User user : userList) {
            System.out.println(user);
        }
        return userList;
    }

    public void cleanUsersTable() {
        USER_DAO.cleanUsersTable();
    }
}
