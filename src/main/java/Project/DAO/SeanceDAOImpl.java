package Project.DAO;

import Project.Model.Seance;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class SeanceDAOImpl implements SeanceDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Seance> get(double vma, Integer typeCourse_id) {

        String hql = "FROM Seance WHERE vma_max = 13 AND typeCourse_id = 1";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        /*query.setParameter("vma1", vma);
        query.setParameter("vma2", vma);
        query.setParameter("typeCourse_id", typeCourse_id);*/

        @SuppressWarnings("unchecked")
        List<Seance> results = Collections.checkedList(query.list(), Seance.class);

        try {
            return results;
        } catch (Exception e) {
            return null;
        }
    }
}
