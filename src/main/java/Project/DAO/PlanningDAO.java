package Project.DAO;

import Project.Model.Planning;
import Project.Model.Seance;
import Project.Model.User;

import java.util.List;

public interface PlanningDAO {
    public long add(Planning planning);
    public List<Planning> get(User user);
    public Planning getPlanning(long id);
}
