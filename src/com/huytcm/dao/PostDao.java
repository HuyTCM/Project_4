package com.huytcm.dao;

import com.huytcm.entities.Post;
import com.huytcm.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;


public class PostDao {
    private final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    public List<Post> getPostAtPage(int page) {
        Session session = sessionFactory.openSession();
        List<Post> posts = new ArrayList<>();

        try {
            String sql = "select p from " + Post.class.getName() + " p";
            Query<Post> query = session.createQuery(sql);
            query.setFirstResult((page - 1) * 5);
            query.setMaxResults(5);

            posts = query.getResultList();
        } catch (Exception e) {
            System.out.println("Can not get any posts!");
        } finally {
            session.close();
        }

        return posts;
    }

    public boolean save(Post post) {
        boolean isSuccess = true;

        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.save(post);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            isSuccess = false;
        } finally {
            session.close();
        }

        return isSuccess;
    }

    public boolean update(Post post) {
        boolean isSuccess = true;

        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();
            session.update(post);
            transaction.commit();
        } catch (Exception  e) {
            transaction.rollback();
            isSuccess = false;
        } finally {
            session.close();
        }

        return  isSuccess;
    }

    public boolean delete(Post post) {
        boolean isSuccess = true;

        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.delete(post);
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
