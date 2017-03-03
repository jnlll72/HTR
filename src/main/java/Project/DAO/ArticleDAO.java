package Project.DAO;

import Project.Model.Article;

public interface ArticleDAO {
    public long add(Article article);
    public Article get(long id,boolean init);
}
