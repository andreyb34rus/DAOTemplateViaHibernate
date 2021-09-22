package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        session.createSQLQuery("CREATE TABLE IF NOT EXISTS users(\n" +
                        "id SERIAL,\n" +
                        "name VARCHAR(50),\n" +
                        "lastName VARCHAR (50),\n" +
                        "age INTEGER,\n" +
                        "PRIMARY KEY (id));")
                .executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void dropUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        session.createSQLQuery("DROP TABLE IF EXISTS users;").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(new User(name, lastName, age));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void removeUserById(long id) {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        User userToRemove = (User) session.load(User.class, id);
        session.delete(userToRemove);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<User> getAllUsers() {
        Session session = Util.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);
        Query query = session.createQuery(criteriaQuery);
        List<User> userList = query.getResultList();
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        session.createSQLQuery("TRUNCATE TABLE users").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
