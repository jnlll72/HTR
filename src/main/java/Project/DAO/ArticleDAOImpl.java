package Project.DAO;

import Project.Model.Article;
import Project.Model.User;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class ArticleDAOImpl implements ArticleDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long add(Article article) {
        Serializable id = sessionFactory.getCurrentSession().save(article);
        return (Long) id;
    }

    @Override
    public Article get(long id, boolean init) {
        Article article = sessionFactory.getCurrentSession().get(Article.class, id);

        if (init)
            Hibernate.initialize(article.getMessages());
        return article;
    }
}
