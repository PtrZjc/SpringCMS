package pl.zajacp.config.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zajacp.dao.ArticleDao;
import pl.zajacp.model.Article;

import java.util.List;

@RestController
@Transactional
@RequestMapping("/article")
public class ArticleController {

    private ArticleDao articleDao;

    @Autowired
    public ArticleController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @GetMapping("/recent/{number}")
    public List<Article> getRecent(@PathVariable("number") int number){
        return articleDao.getRecent(number);
    }

}
