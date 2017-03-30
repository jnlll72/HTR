package Project.Service;

import Project.DAO.TypeSeanceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TypeSeanceServiceImpl implements TypeSeanceService {
    @Autowired
    private TypeSeanceDAO typeSeanceDAO;
}
