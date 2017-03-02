package Project.DAO;

import Project.Model.Forum;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ForumDAOImpl implements ForumDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Forum> getAll() {
        String hql = "FROM Forum";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        @SuppressWarnings("unchecked")
        List<Forum> results = Collections.checkedList(query.list(), Forum.class);

        try {
            return results;
        } catch (Exception e) {
            return null;
        }

    }
}
