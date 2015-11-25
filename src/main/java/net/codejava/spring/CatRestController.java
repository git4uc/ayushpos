package net.codejava.spring;
import java.util.List;















import net.codejava.spring.dao.CategoryDAO;
import net.codejava.spring.dao.CategoryDAO;
import net.codejava.spring.dao.UserDAO;
import net.codejava.spring.model.Category;
import net.codejava.spring.service.CatService;
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
public class CatRestController {

	@Autowired
	   CatService catService;  //Service which will do all data retrieval/manipulation work 
	
    //-------------------Retrieve All Categorys--------------------------------------------------------
	
      
	@RequestMapping(value = "/cat/", method = RequestMethod.GET)
    public ResponseEntity <List<Category>> listAllCategorys() throws Exception {
    	System.out.println("Testing tes"
    			+ ""
    			+ ""
    			+ ""
    			+ "ting /cagepos/cat Y - 11/14");
    	//Implemeted - Usha
    
       List<Category> cats = catService.findAllCategorys();
        if(cats.isEmpty()){
            return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
		for(int i=0; i<cats.size(); i++){
			Category Category = (Category)cats.get(i);
			System.out.println(Category.getName());
		}
        return new ResponseEntity<List<Category>>(cats, HttpStatus.OK);
    }
     
    //-------------------Retrieve Single Category--------------------------------------------------------
      
    @RequestMapping(value = "/cat/single/{id}", method = RequestMethod.GET)
    public ResponseEntity<Category> getCategory(@PathVariable("id") int id) {
        System.out.println("Fetching Category with id " + id);
      //Implemeted - Usha
        Category Category = catService.findById(id);
        if (Category == null) {
            System.out.println("Category with id " + id + " not found");
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Category>(Category, HttpStatus.OK);
    }
  
      
      
    //-------------------find a Category--------------------------------------------------------
    @RequestMapping(value = "/cat/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Category>> getCategory(@PathVariable("name") String usrname) {
        System.out.println("Fetching Category with name " + usrname);
      //Implemeted - Usha
        List<Category> Categorys = catService.findByName(usrname);
        if (Categorys == null) {
            System.out.println("Category with id " + usrname + " not found");
            return new ResponseEntity<List<Category>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Category>>(Categorys, HttpStatus.OK);
    }
    
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/cat/", method = RequestMethod.POST)
    public ResponseEntity<Void> createCategory(@RequestBody Category category,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Category " + category.getName());
  
        if (catService.isCategoryExist(category)) {
            System.out.println("A Category with name " + category.getName() + " already exist");
            ErrorResponse errResp = new ErrorResponse(ErrorCode.INVALID_ID);
         //   return new ResponseEntity<Void>(HttpStatus.CONFLICT);
          //  return Response.status(400).entity(resp).build();
            return new ResponseEntity(errResp,HttpStatus.BAD_REQUEST);
        }
      //Implemeted - Usha
        catService.saveCategory(category);
  
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/cat/{id}").buildAndExpand(category.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
  
     
      
    //------------------- Update a Category --------------------------------------------------------
      
    @RequestMapping(value = "/cat/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Category> updateCategory(@PathVariable("id") int id, @RequestBody Category Category) {
        System.out.println("Updating Category " + id);
          
        Category currentCategory = catService.findById(id);
        
        if (currentCategory==null) {
            System.out.println("Category with id " + id + " not found");
            return new ResponseEntity<Category>(HttpStatus.BAD_REQUEST);
        }
        System.out.println("Category with id " + id + "  found ");
        currentCategory.setName(Category.getName());
        currentCategory.setDescp(Category.getDescp());
 //       currentCategory.setCatalogue((Category.getImage()));
        catService.updateCategory(currentCategory);
        
        return new ResponseEntity<Category>(currentCategory, HttpStatus.OK);
    }
  
     
    
    //------------------- Delete a Category --------------------------------------------------------
    //Implemented
    @RequestMapping(value = "/cat/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Category> deleteCategory(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting Category with id " + id);
        //Implemented
        catService.deleteCategoryById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
  
      
     
    //------------------- Delete All Categorys --------------------------------------------------------
      
    @RequestMapping(value = "/cat/", method = RequestMethod.DELETE)
    public ResponseEntity<Category> deleteAllCategorys() {
        System.out.println("Deleting All Categorys");
  
        catService.deleteAllCategorys();
        return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
    }
  

}
