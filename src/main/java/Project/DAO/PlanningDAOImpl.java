package Project.DAO;

import Project.Model.Planning;
import Project.Model.Seance;
import Project.Model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Repository
public class PlanningDAOImpl implements PlanningDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long add(Planning planning) {
        Serializable id = sessionFactory.getCurrentSession().save(planning);
        return (Long) id;
    }

    @Override
    public List<Planning> get(User user) {

        String hql = "FROM Planning P WHERE P.user = :user";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("user", user);

        @SuppressWarnings("unchecked")
        List<Planning> results = Collections.checkedList(query.list(), Planning.class);

        try {
            return results;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Planning getPlanning(long id) {
        return sessionFactory.getCurrentSession().get(Planning.class, id);
    }

}
