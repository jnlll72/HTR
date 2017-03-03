package Project.Service;

import Project.Model.Article;

public interface ArticleService {
    public long add(Article article);
    public Article get(long id,boolean init);
}
