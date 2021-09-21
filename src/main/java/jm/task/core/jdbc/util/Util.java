package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Util {

    private static Connection INSTANCE = null;
    private static final String PASSWORD = "neyroset7";
    private static final String USERNAME = "root";
    private static final String URL = "jdbc:postgresql://localhost:5432/jmDaoTest";

    private Util() {

    }

    private static void connectToDataBase() {
        try {
            Class.forName("org.postgresql.Driver");
            INSTANCE = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Connection to data base failed.");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (INSTANCE == null) {
            connectToDataBase();
        }
        return INSTANCE;
    }
}
