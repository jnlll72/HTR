package Project.DAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TypeSeanceDAOImpl implements TypeSeanceDAO{
    @Autowired
    private SessionFactory sessionFactory;
}
