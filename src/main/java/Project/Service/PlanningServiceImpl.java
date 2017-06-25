package Project.Service;

import Project.DAO.PlanningDAO;
import Project.Model.Planning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PlanningServiceImpl implements PlanningService {
    @Autowired
    private PlanningDAO planningDAO;

    @Override
    public long add(Planning planning) {
        return planningDAO.add(planning);
    }
}
