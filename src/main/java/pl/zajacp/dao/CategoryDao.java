package pl.zajacp.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.zajacp.model.Category;

@Repository
@Transactional
public class CategoryDao  extends AbstractDao {

    public CategoryDao() {
        setClass(Category.class);
    }
}