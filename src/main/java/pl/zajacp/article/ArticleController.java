package pl.zajacp.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.zajacp.author.AuthorDao;
import pl.zajacp.category.CategoryDao;
import pl.zajacp.author.Author;
import pl.zajacp.category.Category;

import java.util.List;

@Controller
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

    @GetMapping("/all")
    public String showArticles() {
        return "listArticles";
    }

    @GetMapping("/")
    public String addArticle(Model model) {
        model.addAttribute("article", new Article());
        return "formArticle";
    }


    @PostMapping("/")
    public String postArticle(@ModelAttribute Article article) {
        if (article.getId() == null) {
            articleDao.save(article);
        } else {
            articleDao.update(article);
        }
        return "redirect:all";
    }

    @PostMapping("/edit")
    public String editArticle(@RequestParam(name = "id") Long id, Model model) {
        Article aut = articleDao.findById(id);
        model.addAttribute("article", aut);
        return "formArticle";
    }

    @PostMapping("/delete")
    public String deleteArticle(@RequestParam(name = "id") Long id) {
        articleDao.deleteById(id);
        return "redirect:all";
    }

    @ModelAttribute("allArticles")
    public List<Article> allAuthor() {
        return articleDao.findAll();
    }

    @ModelAttribute("allCategories")
    public List<Category> allCategories() {
        List<Category> cats = categoryDao.findAll();
        return cats;
    }

    @ModelAttribute("allAuthors")
    public List<Author> allAuthors() {
        return authorDao.findAll();
    }
}
