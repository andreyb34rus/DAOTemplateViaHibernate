package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class Util {

    private static Connection INSTANCE = null;
    private static SessionFactory SESSION_FACTORY_INSTANCE = null;
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

    // Building of SessionFactory without cfg.hibernate.xml configure file

    private static void createSessionFactory() {

        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.postgresql.Driver");
        properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/jmDaoTest");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "neyroset7");
        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.DEFAULT_SCHEMA, "public");
        properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        properties.put(Environment.HBM2DDL_AUTO, "create-drop");

        Configuration configuration = new Configuration();
        configuration.setProperties(properties);
        configuration.addAnnotatedClass(User.class);

        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        SESSION_FACTORY_INSTANCE = configuration.buildSessionFactory(standardServiceRegistry);
    }

    public static SessionFactory getSessionFactory() {
        if (SESSION_FACTORY_INSTANCE == null) {
            createSessionFactory();
        }
        return SESSION_FACTORY_INSTANCE;
    }
}
