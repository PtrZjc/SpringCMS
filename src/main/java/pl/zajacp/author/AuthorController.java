package pl.zajacp.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.Validator;
import java.util.List;

@Controller
@Transactional
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorDao authorDao;
    private final Validator validator;

    @Autowired
    public AuthorController(AuthorDao authorDao, Validator validator) {
        this.authorDao = authorDao;
        this.validator = validator;
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
    public String postAuthor(@ModelAttribute @Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "formAuthor";
        }

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
