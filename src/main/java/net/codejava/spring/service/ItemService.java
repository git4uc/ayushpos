package net.codejava.spring.service;

import java.util.List;

import net.codejava.spring.model.Item;
  
public interface ItemService {
     
    Item findById(int id);
     
    List<Item> findByName(String name);
     
    void saveItem(Item Item);
     
    void updateItem(Item Item);
     
    void deleteItemById(int id);
 
    List<Item> findAllItems(); 
     
    void deleteAllItems();
     
    public boolean isItemExist(Item Item);
     
}