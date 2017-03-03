package Project.Service;

import Project.DAO.ArticleDAO;
import Project.Model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDAO articleDAO;

    @Override
    public long add(Article article) {
        return articleDAO.add(article);
    }

    @Override
    public Article get(long id,boolean init) {
        return articleDAO.get(id,init);
    }
}
