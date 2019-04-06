package pl.zajacp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.zajacp.dao.IDao;
import pl.zajacp.model.Author;

import java.awt.print.Book;
import java.math.BigDecimal;

@Controller
@Transactional
public class TestController {


    private IDao<Author> authorDao;

    @Autowired
    public TestController(IDao<Author> authorDao) {
        this.authorDao = authorDao;
    }

    @RequestMapping
    @ResponseBody
    public String test() {
        return "Hi!";
    }
}
