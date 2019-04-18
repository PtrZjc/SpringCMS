package pl.zajacp.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.zajacp.dao.AuthorDao;
import pl.zajacp.model.Author;

public class AuthorConverter implements Converter<String, Author> {

   @Autowired
   AuthorDao authorDao;

   @Override
   public Author convert(String s) {
      return authorDao.findById(Long.parseLong(s));
   }
}