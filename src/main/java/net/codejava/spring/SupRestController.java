package net.codejava.spring;
import java.util.List;
















import net.codejava.spring.dao.SupplierDAO;
import net.codejava.spring.dao.SupplierDAO;
import net.codejava.spring.dao.UserDAO;
import net.codejava.spring.model.Supplier;
import net.codejava.spring.service.CatService;
import net.codejava.spring.service.SupService;
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
public class SupRestController {

	@Autowired
	   SupService supService;  //Service which will do all data retrieval/manipulation work 
	
    //-------------------Retrieve All Suppliers--------------------------------------------------------
	
      
	@RequestMapping(value = "/sup/", method = RequestMethod.GET)
    public ResponseEntity <List<Supplier>> listAllSuppliers() throws Exception {
    	System.out.println("Testing tes"
    			+ ""
    			+ ""
    			+ ""
    			+ "ting /cagepos/Sup Y - 11/14");
    	//Implemeted - Usha
    
       List<Supplier> sups = supService.findAllSuppliers();
        if(sups.isEmpty()){
            return new ResponseEntity<List<Supplier>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
		for(int i=0; i<sups.size(); i++){
			Supplier Supplier = (Supplier)sups.get(i);
			System.out.println(Supplier.getName());
		}
        return new ResponseEntity<List<Supplier>>(sups, HttpStatus.OK);
    }
     
    //-------------------Retrieve Single Supplier--------------------------------------------------------
      
    @RequestMapping(value = "/Sup/single/{id}", method = RequestMethod.GET)
    public ResponseEntity<Supplier> getSupplier(@PathVariable("id") int id) {
        System.out.println("Fetching Supplier with id " + id);
      //Implemeted - Usha
        Supplier Supplier = supService.findById(id);
        if (Supplier == null) {
            System.out.println("Supplier with id " + id + " not found");
            return new ResponseEntity<Supplier>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Supplier>(Supplier, HttpStatus.OK);
    }
  
      
      
    //-------------------find a Supplier--------------------------------------------------------
    @RequestMapping(value = "/sup/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Supplier>> getSupplier(@PathVariable("name") String usrname) {
        System.out.println("Fetching Supplier with name " + usrname);
      //Implemeted - Usha
        List<Supplier> Suppliers = supService.findByName(usrname);
        if (Suppliers == null) {
            System.out.println("Supplier with id " + usrname + " not found");
            return new ResponseEntity<List<Supplier>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Supplier>>(Suppliers, HttpStatus.OK);
    }
    
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/sup/", method = RequestMethod.POST)
    public ResponseEntity<Void> createSupplier(@RequestBody Supplier supplier,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Supplier " + supplier.getName());
  
        if (supService.isSupplierExist(supplier)) {
            System.out.println("A Supplier with name " + supplier.getName() + " already exist");
            ErrorResponse errResp = new ErrorResponse(ErrorCode.INVALID_ID);
         //   return new ResponseEntity<Void>(HttpStatus.CONFLICT);
          //  return Response.status(400).entity(resp).build();
            return new ResponseEntity(errResp,HttpStatus.BAD_REQUEST);
        }
      //Implemeted - Usha
        supService.saveSupplier(supplier);
  
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/cat/{id}").buildAndExpand(supplier.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
  
     
      
    //------------------- Update a Supplier --------------------------------------------------------
      
    @RequestMapping(value = "/sup/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Supplier> updateSupplier(@PathVariable("id") int id, @RequestBody Supplier supplier) {
        System.out.println("Updating Supplier " + id);
          
        Supplier currentSupplier = supService.findById(id);
        
        if (currentSupplier==null) {
            System.out.println("Supplier with id " + id + " not found");
            return new ResponseEntity<Supplier>(HttpStatus.BAD_REQUEST);
        }
        System.out.println("Supplier with id " + id + "  found ");
        supplier.setId(currentSupplier.getId());
        supService.updateSupplier(supplier);
        
        return new ResponseEntity<Supplier>(supService.findById(id), HttpStatus.OK);
    }
  
     
    
    //------------------- Delete a Supplier --------------------------------------------------------
    //Implemented
    @RequestMapping(value = "/sup/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Supplier> deleteSupplier(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting Supplier with id " + id);
        //Implemented
        supService.deleteSupplierById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
  
      
     
    //------------------- Delete All Suppliers --------------------------------------------------------
      
    @RequestMapping(value = "/sup/", method = RequestMethod.DELETE)
    public ResponseEntity<Supplier> deleteAllSuppliers() {
        System.out.println("Deleting All Suppliers");
  
        supService.deleteAllSuppliers();
        return new ResponseEntity<Supplier>(HttpStatus.NO_CONTENT);
    }
  

}
