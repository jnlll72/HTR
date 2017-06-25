package Project.Service;

import Project.Model.Seance;

import java.util.List;

public interface SeanceService {
    public List<Seance> get(double vma, Integer typeCourse_id);
}
