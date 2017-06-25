package Project.DAO;

import Project.Model.TypeCourse;

import java.util.List;

public interface TypeCourseDAO {
    public List<TypeCourse> getAll();
    public TypeCourse get(long id);
}
