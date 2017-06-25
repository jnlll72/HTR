package Project.Service;

import Project.DAO.SeanceDAO;
import Project.Model.Seance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SeanceServiceImpl implements SeanceService {
    @Autowired
    private SeanceDAO seanceDAO;

    @Override
    public List<Seance> get(double vma, Integer typeCourse_id) {
        return seanceDAO.get(vma, typeCourse_id);
    }
}
