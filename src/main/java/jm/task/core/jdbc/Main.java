package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Erich", "Gamma", (byte) 33);
        userService.saveUser("Richard", "Helm", (byte) 35);
        userService.saveUser("Ralph", "Johnson", (byte) 39);
        userService.saveUser("John", "Vlissides", (byte) 33);
        userService.getAllUsers();
        userService.cleanUsersTable();
    }
}
