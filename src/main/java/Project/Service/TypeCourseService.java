package Project.Service;

import Project.Model.TypeCourse;

import java.util.List;

public interface TypeCourseService {
    public List<TypeCourse> getAll();
    public TypeCourse get(long id);
}
