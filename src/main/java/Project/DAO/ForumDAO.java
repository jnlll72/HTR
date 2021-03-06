package Project.DAO;

import Project.Model.Forum;

import java.util.List;

public interface ForumDAO {
    public List<Forum> getAll();

    public long add(Forum forum);

    public Forum get(long id);
}
