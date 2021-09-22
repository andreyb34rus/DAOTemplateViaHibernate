package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {

    public static void main(String[] args) {
        UserServiceImpl UserServiceImpl = new UserServiceImpl();
        UserServiceImpl.createUsersTable();
        UserServiceImpl.saveUser("Erich", "Gamma", (byte) 33);
        UserServiceImpl.saveUser("Richard", "Helm", (byte) 35);
        UserServiceImpl.saveUser("Ralph", "Johnson", (byte) 39);
        UserServiceImpl.saveUser("John", "Vlissides", (byte) 33);
        UserServiceImpl.getAllUsers();
        UserServiceImpl.cleanUsersTable();
    }
}
