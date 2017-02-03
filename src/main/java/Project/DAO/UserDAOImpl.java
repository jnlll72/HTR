package Project.DAO;

import Project.Model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long add(User user) {
        Serializable id = sessionFactory.getCurrentSession().save(user);
        return (Long) id;
    }

    @Override
    public User getByEmailPwd(String email, String pwd) {
        javax.persistence.Query query = sessionFactory.getCurrentSession().createQuery("from User m where email = :email and pwd = :pwd");
        query.setParameter("email", email);
        query.setParameter("pwd", pwd);
        try {
            return (User) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
