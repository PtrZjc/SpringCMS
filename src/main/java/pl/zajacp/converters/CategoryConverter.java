package pl.zajacp.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.zajacp.dao.CategoryDao;
import pl.zajacp.model.Category;

public class CategoryConverter implements Converter<String, Category> {
   @Autowired
   CategoryDao categoryDao;

   @Override
   public Category convert(String s) {
      return categoryDao.findById(Long.parseLong(s));
   }
}