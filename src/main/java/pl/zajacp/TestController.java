package pl.zajacp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.zajacp.dao.ArticleDao;
import pl.zajacp.dao.AuthorDao;
import pl.zajacp.dao.CategoryDao;
import pl.zajacp.dao.IDao;
import pl.zajacp.model.Article;
import pl.zajacp.model.Author;
import pl.zajacp.model.Category;

import java.awt.print.Book;
import java.math.BigDecimal;
import java.util.List;

@RestController
@Transactional
public class TestController {


    private AuthorDao authorDao;
    private ArticleDao articleDao;
    private CategoryDao categoryDao;

    @Autowired
    public TestController(AuthorDao authorDao, ArticleDao articleDao, CategoryDao categoryDao) {
        this.authorDao = authorDao;
        this.articleDao = articleDao;
        this.categoryDao = categoryDao;
    }

    @RequestMapping
    public String test() {
        return "Hi!";
    }

    @RequestMapping("/last")
    public String last() {

        List<Article> lastArticles = articleDao.getRecent(5);
        return lastArticles.toString();
    }

    @RequestMapping("/check")
    public String all() {
        Article article = (Article) articleDao.findById(50);
        Author author = article.getAuthor();
        return author.getFirstName();
    }

    /*
    @RequestMapping("/add")
    public String add() {
        Author author = new Author();
        author.setFirstName("Mikołaj");
        author.setLastName("Kopernik(ąźśó)");

        Category category = new Category();
        category.setName("Fizyka");
*/
/*        Category category = categoryDao.findAll()
                .stream()
                .filter(x-> x.getName().contains("Physical"))
                .findFirst()
                .orElse(null);*//*


        Article paper = new Article();
        paper.setAuthor(author);
        paper.setCategory(category);
        paper.setTitle("O obrotach sfer niebieskich.");
        paper.setContent("zawiera wykład heliocentrycznej i heliostatycznej budowy wszechświata.");

        categoryDao.save(category);
        authorDao.save(author);
        articleDao.save(paper);

        return "Hi!";
    }
*/
}
