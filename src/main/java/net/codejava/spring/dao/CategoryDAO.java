package net.codejava.spring.dao;


import java.util.List;

import net.codejava.spring.model.Category;

public interface CategoryDAO {
	public List<Category> list() throws Exception;
	public void updateCategory(Category cate);
	public void addCategory(Category cate);	
    public void deleteCategory(int id);
    public List<Category> getCategoryByName(String name) throws Exception;
    public Category getCategoryByID(int id) throws Exception;
}
