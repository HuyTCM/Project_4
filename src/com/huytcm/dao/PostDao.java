package com.huytcm.dao;

import com.huytcm.entities.Post;
import com.huytcm.entities.PostDetail;
import com.huytcm.entities.User;
import com.huytcm.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;


public class PostDao {
    private final static int MAX_SHORT_CONTENT_LENGTH = 200;
    private final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    public Post getPostById(Long id) {
        Session session = sessionFactory.openSession();
        Post post;
        try {
            String sql = "select p from " + Post.class.getName() + " p where p.id = :postId";
            Query<Post> query = session.createQuery(sql);
            query.setParameter("postId", id);
            post = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            post = null;
        } finally {
            session.close();
        }
        return post;
    }

    public List<Post> getPostAtPage(int page) {
        Session session = sessionFactory.openSession();
        List<Post> posts = new ArrayList<>();

        try {
            String sql = "select p from " + Post.class.getName() + " p order by p.createDate desc";
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

    public Long getNumOfPosts() {
        Session session = sessionFactory.openSession();
        Long numOfPost;
        try {
            String sql = "select count(1) from " + Post.class.getName();
            System.out.println(sql);
            Query query = session.createQuery(sql);
            numOfPost = (Long)query.uniqueResult();
            System.out.println(numOfPost);
        } catch (Exception e) {
            numOfPost = Long.parseLong("0");
            e.printStackTrace();
        } finally {
            session.close();
        }
        return numOfPost;
    }

    public boolean saveNewPost(String title, String content, User author) {
        //TODO: set user
        boolean isSuccess = true;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            Post post = new Post();
            post.setTitle(title);
            String shortContent = getShortContent(content);
            System.out.println(shortContent);
            post.setShortContent(shortContent);
            post.setAuthor(author);
            session.flush();

            PostDetail postDetail = new PostDetail();
            postDetail.setContent(content);

            post.setPostDetail(postDetail);
            postDetail.setPost(post);

            session.save(post);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            isSuccess = false;
        } finally {
            session.close();
        }
        return isSuccess;
    }

    private String getShortContent(String content) {
        String shortContent = "";
        if (content != null) {
            // get the first 200 words in main content
            if (content.length() > MAX_SHORT_CONTENT_LENGTH) {
                shortContent = content.substring(0, MAX_SHORT_CONTENT_LENGTH);
            } else {
                shortContent = content;
            }
        }
        return shortContent.replaceAll("\\<[^>]*>","").replaceAll("&nbsp;", " ");
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
