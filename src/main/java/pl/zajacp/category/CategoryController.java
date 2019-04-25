package pl.zajacp.category;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.zajacp.article.ArticleDao;
import pl.zajacp.author.AuthorDao;

import javax.validation.Valid;
import java.util.List;

@Transactional
@Controller
@RequestMapping("/categories")
public class CategoryController {

    private ArticleDao articleDao;
    private CategoryDao categoryDao;
    private AuthorDao authorDao;

    @Autowired
    public CategoryController(ArticleDao articleDao, CategoryDao categoryDao, AuthorDao authorDao) {
        this.articleDao = articleDao;
        this.categoryDao = categoryDao;
        this.authorDao = authorDao;
    }

    @GetMapping("/all")
    public String showCategories() {
        return "listCategories";
    }

    @GetMapping("/")
    public  String addCategory(Category category, Model model) {
        model.addAttribute("category", new Category());
        return "formCategory";
    }

    @PostMapping("/")
    public String postCategory(@ModelAttribute @Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "formCategory";
        }

        if (category.getId() == null) {
            categoryDao.save(category);
        } else {
            categoryDao.update(category);
        }
        return "redirect:all";
    }

    @PostMapping("/edit")
    public String editCategory(@RequestParam(name = "id") Long id, Model model) {
        Category cat = categoryDao.findById(id);
        model.addAttribute("category", cat);
        return "formCategory";
    }

    @PostMapping("/delete")
    public String deleteCategory(@RequestParam(name = "id") Long id) {
        categoryDao.deleteById(id);
        return "redirect:all";
    }

    @ModelAttribute("allCategories")
    public List<Category> allCategories() {
        List<Category> cats = categoryDao.findAll();
        return cats;
    }
}
