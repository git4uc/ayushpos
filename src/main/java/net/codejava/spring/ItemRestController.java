package net.codejava.spring;
import java.util.List;











import net.codejava.spring.dao.ItemDAO;
import net.codejava.spring.dao.UserDAO;
import net.codejava.spring.model.Item;
import net.codejava.spring.service.ItemService;
import net.codejava.spring.service.UserService;
import net.codejava.spring.util.ErrorCode;
import net.codejava.spring.util.ErrorResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
  
@RestController
public class ItemRestController {

	@Autowired
	   ItemService itemService;  //Service which will do all data retrieval/manipulation work 
	
    //-------------------Retrieve All Items--------------------------------------------------------
	
      
	@RequestMapping(value = "/item/", method = RequestMethod.GET)
    public ResponseEntity <List<Item>> listAllItems() throws Exception {
    	System.out.println("Testing testing /cagepos/Item Y - 11/14");
    	List<Item> Items;
    	try{
    	//Implemeted - Usha
    
        Items = itemService.findAllItems();
        if(Items.isEmpty()){
            return new ResponseEntity<List<Item>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
		for(int i=0; i<Items.size(); i++){
			Item Item = (Item)Items.get(i);
			System.out.println(Item.getName());
		}
    	}
		catch(Exception e){
			
			return new ResponseEntity(HttpStatus.METHOD_FAILURE);
		}
        return new ResponseEntity<List<Item>>(Items, HttpStatus.OK);
    }
     
    //-------------------Retrieve Single Item--------------------------------------------------------
      
    @RequestMapping(value = "/item/single/{id}", method = RequestMethod.GET)
    public ResponseEntity<Item> getItem(@PathVariable("id") int id) {
        System.out.println("Fetching Item with id " + id);
      //Implemeted - Usha
        Item Item = itemService.findById(id);
        if (Item == null) {
            System.out.println("Item with id " + id + " not found");
            return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Item>(Item, HttpStatus.OK);
    }
  
      
      
    //-------------------find a Item--------------------------------------------------------
    @RequestMapping(value = "/item/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Item>> getItem(@PathVariable("name") String usrname) {
        System.out.println("Fetching Item with name " + usrname);
      //Implemeted - Usha
        List<Item> Items = itemService.findByName(usrname);
        if (Items == null) {
            System.out.println("Item with id " + usrname + " not found");
            return new ResponseEntity<List<Item>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Item>>(Items, HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/item/", method = RequestMethod.POST)
    public ResponseEntity<Void> createItem(@RequestBody Item Item,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Item " + Item.getName());
  
        if (itemService.isItemExist(Item)) {
            System.out.println("A Item with name " + Item.getName() + " already exist");
            ErrorResponse errResp = new ErrorResponse(ErrorCode.INVALID_ID);
            return new ResponseEntity(errResp,HttpStatus.BAD_REQUEST);
        }
      //Implemeted - Usha
        itemService.saveItem(Item);
  
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/item/{id}").buildAndExpand(Item.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
  
     
      
    //------------------- Update a Item --------------------------------------------------------
      
    @RequestMapping(value = "/item/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Item> updateItem(@PathVariable("id") int id, @RequestBody Item item) {
        System.out.println("Updating Item " + id);
          
        Item currentItem = itemService.findById(id);
        
        if (currentItem==null) {
            System.out.println("Item with id " + id + " not found");
            return new ResponseEntity<Item>(HttpStatus.BAD_REQUEST);
        }
        System.out.println("Item with id " + id + "  found ");
        //Implemented - Usha
        item.setId(currentItem.getId());
        itemService.updateItem(item);
        
        return new ResponseEntity<Item>(itemService.findById(id), HttpStatus.OK);
    }
  
     
    
    //------------------- Delete a Item --------------------------------------------------------
    //Implemented
    @RequestMapping(value = "/item/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Item> deleteItem(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting Item with id " + id);
        //Implemented
        itemService.deleteItemById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
  
      
     
    //------------------- Delete All Items --------------------------------------------------------
      
    @RequestMapping(value = "/item/", method = RequestMethod.DELETE)
    public ResponseEntity<Item> deleteAllItems() {
        System.out.println("Deleting All Items");
  
        itemService.deleteAllItems();
        return new ResponseEntity<Item>(HttpStatus.NO_CONTENT);
    }
  

}
