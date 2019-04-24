package pl.zajacp.category;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.zajacp.generic.AbstractDao;

@Repository
@Transactional
public class CategoryDao  extends AbstractDao<Category> {

    public CategoryDao() {
        setClass(Category.class);
    }
}