package pl.zajacp.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.zajacp.model.Author;
import pl.zajacp.model.Category;

import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class CategoryDao  extends AbstractDao<Category>{

    public CategoryDao() {
        setClass(Category.class);
    }
}