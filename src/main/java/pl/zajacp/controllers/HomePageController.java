package pl.zajacp.controllers;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.zajacp.article.ArticleDao;
import pl.zajacp.article.Article;

import java.util.List;

@Controller
@Transactional
public class HomePageController {
    private ArticleDao articleDao;

    @Autowired
    public HomePageController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @GetMapping("/")
    private String openHome(Model model) {
        List<Article> arts = articleDao.getRecent(5);
        Hibernate.initialize(arts);
        model.addAttribute("recentArticles",arts);
        return "home";
    }
}
