package pl.zajacp.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.zajacp.model.Article;

@Repository
@Transactional
public class ArticleDao extends AbstractDao {

    public ArticleDao() {
        setClass(Article.class);
    }
}