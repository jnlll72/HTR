package Project.Service;

import Project.DAO.TypeCourseDAO;
import Project.Model.TypeCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TypeCourseServiceImpl implements TypeCourseService {
    @Autowired
    private TypeCourseDAO typeCourseDAO;

    @Override
    public List<TypeCourse> getAll() {
        return typeCourseDAO.getAll();
    }

    @Override
    public TypeCourse get(long id) {
        return typeCourseDAO.get(id);
    }


}
