package Project.DAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SeanceDAOImpl implements SeanceDAO {
    @Autowired
    private SessionFactory sessionFactory;
}
