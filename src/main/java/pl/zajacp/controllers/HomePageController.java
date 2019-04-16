package pl.zajacp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.zajacp.dao.ArticleDao;
import pl.zajacp.model.Article;

import java.util.Arrays;
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
        model.addAttribute("recentArticles",articleDao.getRecent(5));
        return "home";
    }
}
