package net.codejava.spring.service;

import java.util.List;

import net.codejava.spring.model.Category;
  
public interface CatService {
     
    Category findById(int id);
     
    List<Category> findByName(String name);
     
    void saveCategory(Category category) throws Exception;
     
    void updateCategory(Category category);
     
    void deleteCategoryById(int id) throws Exception;
 
    List<Category> findAllCategorys(); 
     
    void deleteAllCategorys();
     
    public boolean isCategoryExist(Category category);
     
}