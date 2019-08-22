package com.huytcm.dao;

import com.huytcm.entities.User;
import com.huytcm.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.List;

public class UserDao {
    private final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    public User getUserByUsername(String username) {
        Session session = sessionFactory.openSession();
        User user;
        try {
            String sql = "select user from " + User.class.getName() + " user where user.username = :username";
            Query<User> query = session.createQuery(sql);
            query.setParameter("username", username);
            user = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("user not found");
            user = null;
        } finally {
            session.close();
        }
        return user;
    }
}
