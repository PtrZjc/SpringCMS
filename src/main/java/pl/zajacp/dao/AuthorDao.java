package pl.zajacp.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.zajacp.model.Author;

@Repository
@Transactional
public class AuthorDao extends AbstractDao {

    public AuthorDao() {
        setClass(Author.class);
    }
}