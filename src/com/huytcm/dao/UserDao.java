package com.huytcm.dao;

import com.huytcm.entities.User;
import com.huytcm.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;

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

    public boolean save(User user) {
        boolean isSuccess = true;

        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            isSuccess = false;
        } finally {
            session.close();
        }

        return isSuccess;
    }

    public boolean update(User user) {
        boolean isSuccess = true;

        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();
            session.update(user);
            transaction.commit();
        } catch (Exception  e) {
            transaction.rollback();
            isSuccess = false;
        } finally {
            session.close();
        }

        return  isSuccess;
    }

    public boolean delete(User user) {
        boolean isSuccess = true;

        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.delete(user);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            isSuccess = false;
        } finally {
            session.close();
        }

        return isSuccess;
    }
}
