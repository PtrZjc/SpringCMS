package pl.zajacp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.AbstractController;
import pl.zajacp.dao.ArticleDao;
import pl.zajacp.dao.AuthorDao;
import pl.zajacp.dao.CategoryDao;
import pl.zajacp.model.Article;
import pl.zajacp.model.Author;
import pl.zajacp.model.Category;

import java.util.List;

@RestController
@Transactional
@RequestMapping("/articles")
public class ArticleController {

    private ArticleDao articleDao;
    private CategoryDao categoryDao;
    private AuthorDao authorDao;

    @Autowired
    public ArticleController(ArticleDao articleDao, CategoryDao categoryDao, AuthorDao authorDao) {
        this.articleDao = articleDao;
        this.categoryDao = categoryDao;
        this.authorDao = authorDao;
    }




    @ModelAttribute("allCategories")
    public List<Category> allBooks(){
        return categoryDao.findAll();
    }

    @ModelAttribute("allAuthors")
    public List<Author> allPublishers(){
        return authorDao.findAll();
    }

    @ModelAttribute("allArticles")
    public List<Article> allAuthor(){
        return articleDao.findAll();
    }

}
