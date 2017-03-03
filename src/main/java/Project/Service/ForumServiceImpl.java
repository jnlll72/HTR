package Project.Service;

import Project.DAO.ForumDAO;
import Project.Model.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ForumServiceImpl implements ForumService {

    @Autowired
    private ForumDAO forumDAO;

    @Override
    public List<Forum> getAll() {
        return forumDAO.getAll();
    }

    @Override
    public long add(Forum forum) {
        return forumDAO.add(forum);
    }

    @Override
    public Forum get(long id) {
        return forumDAO.get(id);
    }
}
