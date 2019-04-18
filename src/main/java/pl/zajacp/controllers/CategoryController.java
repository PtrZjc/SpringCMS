package pl.zajacp.controllers;


import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.zajacp.dao.ArticleDao;
import pl.zajacp.dao.AuthorDao;
import pl.zajacp.dao.CategoryDao;
import pl.zajacp.model.Article;
import pl.zajacp.model.Author;
import pl.zajacp.model.Category;

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
    public String postCategory(@ModelAttribute Category category) {
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
