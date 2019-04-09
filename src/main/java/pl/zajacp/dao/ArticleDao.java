package pl.zajacp.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.zajacp.model.Article;

import java.awt.print.Book;
import java.util.List;

@Repository
@Transactional
public class ArticleDao extends AbstractDao<Article>{

    public ArticleDao() {
        setClass(Article.class);
    }

    public List getRecent(int number){
        return entityManager.createQuery("SELECT a FROM Article a order by created desc").setMaxResults(number)
                .getResultList();
    }
}