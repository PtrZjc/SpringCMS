package pl.zajacp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.zajacp.dao.ArticleDao;
import pl.zajacp.dao.AuthorDao;
import pl.zajacp.dao.CategoryDao;
import pl.zajacp.model.Article;
import pl.zajacp.model.Author;
import pl.zajacp.model.Category;

import java.awt.print.Book;
import java.util.List;

@Transactional
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
    private String showCategories() {
        return "listCategories";
    }

    @GetMapping("/")
    private String addCategory(Category category, Model model) {
        model.addAttribute("category",new Category());
        return "formCategory";
    }

    @PostMapping("/")
    public String postCategory(@ModelAttribute Category category) {
        if(category.getId()==null){
            categoryDao.save(category);
        }else{
            categoryDao.update(category);
        }
        return "redirect:all";
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
