package pl.zajacp.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.zajacp.author.AuthorDao;
import pl.zajacp.category.CategoryDao;
import pl.zajacp.author.Author;
import pl.zajacp.category.Category;
import pl.zajacp.validation.DraftValidation;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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
    public String postArticle(@ModelAttribute @Valid Article article, BindingResult result) {
        if (result.hasErrors()) {
            return "formArticle";
        }

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

    @GetMapping("/drafts")
    public String addDraft(Model model) {
        Article draft = new Article();
        draft.setDraft(true);
        model.addAttribute("article", draft);
        return "formDraft";
    }

    @PostMapping("/drafts")
    public String postDraft(@ModelAttribute @Validated({DraftValidation.class}) Article article, BindingResult result) {
        if (result.hasErrors()) {
            return "formArticle";
        }

        if (article.getId() == null) {
            articleDao.save(article);
        } else {
            articleDao.update(article);
        }
        return "redirect:all";
    }

    @GetMapping("drafts/all")
    public String showDrafts(Model model) {
        model.addAttribute("draft",true);
        return "listArticles";
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

    @ModelAttribute("allDrafts")
    public List<Article> addDrafts() {
        return articleDao.findAll().stream().filter(x->Boolean.TRUE.equals(x.getDraft())).collect(Collectors.toList());
    }
}
