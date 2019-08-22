import com.huytcm.dao.UserDao;
import com.huytcm.entities.User;
import com.huytcm.utils.HibernateUtils;
import javafx.util.Pair;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.Map;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
//            Configuration configuration = new Configuration();
//            configuration.configure();

//            ourSessionFactory = configuration.buildSessionFactory();
            ourSessionFactory = HibernateUtils.getSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
//        final Session session = getSession();
//        try {
//            System.out.println("querying all the managed entities...");
//            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
//            for (EntityType<?> entityType : metamodel.getEntities()) {
//                final String entityName = entityType.getName();
//                final Query query = session.createQuery("from " + entityName);
//                System.out.println("executing: " + query.getQueryString());
//                for (Object o : query.list()) {
//                    System.out.println("  " + o);
//                }
//            }
//        } finally {
//            session.close();
//        }
        UserDao userDao = new UserDao();
        User user = userDao.getUserByUsername("huytcm");
        if (user != null) {
            System.out.println("found a user: " + user.getUsername());
        } else {
            System.out.println("user not found");
        }

    }
}