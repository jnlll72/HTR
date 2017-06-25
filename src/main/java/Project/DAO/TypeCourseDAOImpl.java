package Project.DAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TypeCourseDAOImpl implements TypeCourseDAO {
    @Autowired
    private SessionFactory sessionFactory;
}
