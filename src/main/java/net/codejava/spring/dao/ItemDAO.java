package net.codejava.spring.dao;

import java.util.List;

import net.codejava.spring.model.Item;

public interface ItemDAO {
	public List<Item> list() throws Exception;
	public void updateItem(Item Item);
	public void addItem(Item Item);	
    public void deleteItem(int id);
    public List<Item> getItemByName(String name) throws Exception;
    public Item getItemByID(int id) throws Exception;
	public Object getItemByCode(String code);
	
}
