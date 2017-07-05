package Project.Service;

import Project.DAO.PlanningDAO;
import Project.Model.Planning;
import Project.Model.Seance;
import Project.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlanningServiceImpl implements PlanningService {
    @Autowired
    private PlanningDAO planningDAO;

    @Override
    public long add(Planning planning) {
        return planningDAO.add(planning);
    }

    @Override
    public List<Planning> get(User user) {
        return planningDAO.get(user);
    }

    @Override
    public Planning getPlanning(long id) {
        return planningDAO.getPlanning(id);
    }

}
