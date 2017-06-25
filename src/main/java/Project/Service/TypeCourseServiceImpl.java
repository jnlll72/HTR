package Project.Service;

import Project.DAO.TypeCourseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TypeCourseServiceImpl implements TypeCourseService {
    @Autowired
    private TypeCourseDAO typeCourseDAO;
}
