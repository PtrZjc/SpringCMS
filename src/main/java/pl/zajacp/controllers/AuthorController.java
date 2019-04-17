package pl.zajacp.controllers;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.zajacp.dao.ArticleDao;
import pl.zajacp.dao.AuthorDao;
import pl.zajacp.dao.AuthorDao;
import pl.zajacp.dao.CategoryDao;
import pl.zajacp.model.Article;
import pl.zajacp.model.Author;
import pl.zajacp.model.Author;

import java.util.List;

@Controller
@Transactional
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorDao authorDao;

    @Autowired
    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("/all")
    public String showAuthors() {
        return "listAuthors";
    }

    @GetMapping("/")
    public String addAuthor(Author author, Model model) {
        model.addAttribute("author", new Author());
        return "formAuthor";
    }

    @PostMapping("/")
    public String postAuthor(@ModelAttribute Author author) {
        if (author.getId() == null) {
            authorDao.save(author);
        } else {
            authorDao.update(author);
        }
        return "redirect:all";
    }

    @PostMapping("/edit")
    public String editAuthor(@RequestParam(name = "id") Long id, Model model) {
        Author aut = authorDao.findById(id);
        model.addAttribute("author", aut);
        return "formAuthor";
    }

    @PostMapping("/delete")
    public String deleteAuthor(@RequestParam(name = "id") Long id) {
        authorDao.deleteById(id);
        return "redirect:all";
    }


    @ModelAttribute("allAuthors")
    public List<Author> allAuthors(){
        return authorDao.findAll();
    }
}
