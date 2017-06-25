package Project.DAO;

import Project.Model.Planning;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class PlanningDAOImpl implements PlanningDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long add(Planning planning) {
        Serializable id = sessionFactory.getCurrentSession().save(planning);
        return (Long) id;
    }
}
