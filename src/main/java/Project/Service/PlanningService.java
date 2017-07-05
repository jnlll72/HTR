package Project.Service;

import Project.Model.Planning;
import Project.Model.Seance;
import Project.Model.User;

import java.util.List;

public interface PlanningService {
    public long add(Planning planning);
    public List<Planning> get(User user);
    public Planning getPlanning(long id);
}
