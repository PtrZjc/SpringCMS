package pl.zajacp.author;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.zajacp.generic.AbstractDao;

@Repository
@Transactional
public class AuthorDao extends AbstractDao<Author> {

    public AuthorDao() {
        setClass(Author.class);
    }
}