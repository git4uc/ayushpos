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
import net.codejava.spring.model.Item;
 
@Service("ItemService")
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
     
    
    public void saveItem(Item Item) {
        Item.setId(counter.incrementAndGet());
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
/**        Items.add(new Item(counter.incrementAndGet(),"Sam", "NY", "sam@abc.com",35,434223,"415-241-2404"));
        Items.add(new Item(counter.incrementAndGet(),"Tomy", "ALBAMA", "tomy@abc.com",26,34324234,"415-241-2404"));
        Items.add(new Item(counter.incrementAndGet(),"Kelly", "NEBRASKA", "kelly@abc.com",28,23423423,"415-241-2404"));
 **/       
        return listItems;
    }
 
   // @ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/applicationContext.xml"})
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("servlet-context.xml");
        
        
        ItemService itmImpl = (ItemService) context.getBean("ItemService");
        Item item = new Item(23);
        item.setCode("DDD");
        item.setTax(1);
    	//itmImpl.saveItem(item); 
        
        Item item1 = itmImpl.findById(1); 
        item1.setName("DLY PODI");
        itmImpl.updateItem(item1);
    	List<Item> Items = itmImpl.findByName("POD"); 
       // List<Item> Items = usrImpl.findAllItems();
    	for(Item itm1 : Items){
    		System.out.println(itm1.getName());
    		//System.out.println(usr1.getPrice());
    	}
    	/**Item.setEmail("New Email update.com");
    	usrImpl.updateItem(Item);
    	Item.setId(2);
    	usrImpl.deleteItemById(Item.getId()); **/
    	System.exit(0);
    }

	
}