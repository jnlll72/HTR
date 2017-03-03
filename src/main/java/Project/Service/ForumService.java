package Project.Service;

import Project.Model.Forum;

import java.util.List;

public interface ForumService {
    public List<Forum> getAll();
    public long add(Forum forum);
    public Forum get(long id);
}
