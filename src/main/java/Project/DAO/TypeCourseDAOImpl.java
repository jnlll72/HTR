package Project.DAO;

import Project.Model.TypeCourse;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class TypeCourseDAOImpl implements TypeCourseDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<TypeCourse> getAll() {
        String hql = "FROM TypeCourse";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        @SuppressWarnings("unchecked")
        List<TypeCourse> results = Collections.checkedList(query.list(), TypeCourse.class);

        try {
            return results;
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public TypeCourse get(long id) {
        return sessionFactory.getCurrentSession().get(TypeCourse.class, id);
    }
}
