package Project.DAO;

import Project.Model.Seance;

import java.util.List;

public interface SeanceDAO {
    public List<Seance> get(double vma, Integer typeCourse_id);
}
