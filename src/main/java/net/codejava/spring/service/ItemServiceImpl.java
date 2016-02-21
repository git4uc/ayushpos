package net.codejava.spring.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 



import net.codejava.spring.dao.ItemDAO;
import net.codejava.spring.model.Category;
import net.codejava.spring.model.Item;
import net.codejava.spring.model.PurchaseOrder;
import net.codejava.spring.model.Supplier;
 
@Service("itemService")
@Transactional
public class ItemServiceImpl implements ItemService{
     
    private static final AtomicInteger counter = new AtomicInteger();
     
    private static List<Item> Items;
    
	@Autowired
	private ItemDAO ItemDao;
     
      public List<Item> findAllItems() {
        return populateDummyItems();
    }
     
    public Item findById(int id) {
    	try {
			return ItemDao.getItemByID(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
     
    public List<Item> findByName(String name) {
        
    	try {
			return ItemDao.getItemByName(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
     
    
  public List<Item> findByCatName(String catname) {
        
    	try {
			return ItemDao.getItemByCatname(catname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
  
    public void saveItem(Item Item) {
      //  Item.setId(counter.incrementAndGet()); use the DB auto increament
        ItemDao.addItem(Item);
    }
 
    public void updateItem(Item Item) {
    	ItemDao.updateItem(Item);
    }
 
    public void deleteItemById(int id) {
    	ItemDao.deleteItem(id);
  
    }
 
    public boolean isItemExist(Item Item) {
      return findByCode(Item.getCode())!=null;
    }
     
    private Object findByCode(String code) {
       	try {
    			return ItemDao.getItemByCode(code);
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		return null;
	}

	public void deleteAllItems(){
        Items.clear();
    }
 
    private 
    List<Item> populateDummyItems(){
 		List<Item> listItems = null;
		try {
			listItems = ItemDao.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return listItems;
    }
 
   // @ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/applicationContext.xml"})
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("servlet-context.xml");
        
        
        ItemService itmImpl = (ItemService) context.getBean("itemService");
 /**       Category cat = new Category(1);
        //   cat.setId(31);
        //   cat.setName("New DDD");
           
      Item item = new Item(8);
        item.setCode("ITEMN11");
        item.setTax(1);
        cat.setId(34);
     item.setCategory(cat); 
     
     PurchaseOrder po = new PurchaseOrder();
     po.setId(43);
     item.setPo(po);
    	itmImpl.saveItem(item); **/
        
  /**      Item item1 = itmImpl.findById(36); 
        item1.setName("DLY PODI11");
        item1.setDeleted(true); **/
       // Category cat1 = item1.getCategory();
/**        Category cat1 = new Category(1);
        cat1.setId(34);
        
       item1.setCategory(cat1);
        itmImpl.updateItem(item1); **/
    //	List<Item> Items = itmImpl.findByName("POD"); 
        List<Item> Items = itmImpl.findAllItems();
      //  List<Item> Items = itmImpl.findByCatName("breakfast");
    	for(Item itm1 : Items){
    		System.out.println("Item Found " + itm1.getName());
    		System.out.println("Cat Found " + itm1.getCategory().getName());
    		System.out.println("PO Found " + itm1.getPo().getOrderNumber());
    		System.out.println("Deleted " + itm1.isDeleted());
    		//System.out.println(usr1.getPrice());
    	}
    	
    	/**Item.setEmail("New Email update.com");
    	usrImpl.updateItem(Item);
    	Item.setId(2);
    	usrImpl.deleteItemById(Item.getId()); **/
    	System.exit(0);
    }

	
}