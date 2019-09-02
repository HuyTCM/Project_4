package com.huytcm.dao;

import com.huytcm.entities.PostDetail;
import com.huytcm.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class PostDetailDao {
    private final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    public PostDetail getPostDetailByPostId(Long postId) {
        Session session = sessionFactory.openSession();
        PostDetail postDetail;

        try {
            String sql = "select p from " + PostDetail.class.getName() + " p where p.post.id = :postId";
            Query<PostDetail> query = session.createQuery(sql);
            query.setParameter("postId", postId);
            postDetail = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            postDetail = null;
        } finally {
            session.close();
        }
        return postDetail;
    }

    public boolean save(PostDetail postDetail) {
        boolean isSuccess = true;

        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.save(postDetail);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            isSuccess = false;
        } finally {
            session.close();
        }

        return isSuccess;
    }

    public boolean update(PostDetail postDetail) {
        boolean isSuccess = true;

        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();
            session.update(postDetail);
            transaction.commit();
        } catch (Exception  e) {
            transaction.rollback();
            isSuccess = false;
        } finally {
            session.close();
        }

        return  isSuccess;
    }

    public boolean delete(PostDetail postDetail) {
        boolean isSuccess = true;

        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.delete(postDetail);
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
