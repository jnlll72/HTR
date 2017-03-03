package Project.DAO;

import Project.Model.Message;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class MessageDAOImpl implements MessageDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long add(Message message) {
        Serializable id = sessionFactory.getCurrentSession().save(message);
        return (Long) id;
    }
}
