package net.codejava.spring;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;














import java.util.Set;

import net.codejava.spring.dao.SalesOrderDAO;
import net.codejava.spring.dao.UserDAO;
import net.codejava.spring.model.OrderDetail;
import net.codejava.spring.model.SalesOrder;
import net.codejava.spring.service.SalesOrderService;
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
public class SalesOrderRestController {

	@Autowired
	   SalesOrderService SalesOrderService;  //Service which will do all data retrieval/manipulation work 
	
    //-------------------Retrieve All SalesOrders--------------------------------------------------------
	
      
	@RequestMapping(value = "/SalesOrder/", method = RequestMethod.GET)
    public ResponseEntity <List<SalesOrder>> listAllSalesOrders() throws Exception {
    	System.out.println("Testing testing /cagepos/SalesOrder Y - 11/14");
    	//Implemeted - Usha
    
       List<SalesOrder> SalesOrders = SalesOrderService.findAllSalesOrders();
        if(SalesOrders.isEmpty()){
            return new ResponseEntity<List<SalesOrder>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
		for(int i=0; i<SalesOrders.size(); i++){
			SalesOrder SalesOrder = (SalesOrder)SalesOrders.get(i);
			System.out.println(SalesOrder.getOrderNumber());
		}
        return new ResponseEntity<List<SalesOrder>>(SalesOrders, HttpStatus.OK);
    }
     
    //-------------------Retrieve Single SalesOrder--------------------------------------------------------
      
    @RequestMapping(value = "/SalesOrder/single/{id}", method = RequestMethod.GET)
    public ResponseEntity<SalesOrder> getSalesOrder(@PathVariable("id") int id) {
        System.out.println("Fetching SalesOrder with id " + id);
      //Implemeted - Usha
        SalesOrder SalesOrder = SalesOrderService.findById(id);
        if (SalesOrder == null) {
            System.out.println("SalesOrder with id " + id + " not found");
            return new ResponseEntity<SalesOrder>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<SalesOrder>(SalesOrder, HttpStatus.OK);
    }
  
      
      
    //-------------------find a SalesOrder--------------------------------------------------------
    @RequestMapping(value = "/SalesOrder/{sno}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalesOrder>> getSalesOrder(@PathVariable("sno") String sno) {
        System.out.println("Fetching SalesOrder with name " + sno);
      //Implemeted - Usha
        List<SalesOrder> SalesOrders = SalesOrderService.findByOrderNo(sno);
        if (SalesOrders == null) {
            System.out.println("SalesOrder with id " + sno + " not found");
            return new ResponseEntity<List<SalesOrder>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<SalesOrder>>(SalesOrders, HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/SalesOrder/", method = RequestMethod.POST)
    public ResponseEntity<Void> createSalesOrder(@RequestBody SalesOrder SalesOrder,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating SalesOrder " + SalesOrder.getOrderNumber());
  
        if (SalesOrderService.isSalesOrderExist(SalesOrder)) {
            System.out.println("A SalesOrder with name " + SalesOrder.getOrderNumber()+ " already exist");
            ErrorResponse errResp = new ErrorResponse(ErrorCode.INVALID_ID);
         //   return new ResponseEntity<Void>(HttpStatus.CONFLICT);
          //  return Response.status(400).entity(resp).build();
            return new ResponseEntity(errResp,HttpStatus.BAD_REQUEST);
        }
      //Implemeted - Usha
        SalesOrderService.saveSalesOrder(SalesOrder);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/SalesOrder/{id}").buildAndExpand(SalesOrder.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
  
     
      
    //------------------- Update a SalesOrder --------------------------------------------------------
      
    @RequestMapping(value = "/SalesOrder/{id}", method = RequestMethod.PUT)
    public ResponseEntity<SalesOrder> updateSalesOrder(@PathVariable("id") int id, @RequestBody SalesOrder salesOrder) {
        System.out.println("Updating SalesOrder " + id);
          
        SalesOrder currentSalesOrder = SalesOrderService.findById(id);
        
        if (currentSalesOrder==null) {
            System.out.println("SalesOrder with id " + id + " not found");
            return new ResponseEntity<SalesOrder>(HttpStatus.BAD_REQUEST);
        }
        System.out.println("SalesOrder with id " + id + "  found ");
        salesOrder.setId(currentSalesOrder.getId());
     //   currentSalesOrder.setOrderDetails(SalesOrder.getOrderDetails());

        SalesOrderService.updateSalesOrder(salesOrder);
        
        return new ResponseEntity<SalesOrder>(salesOrder, HttpStatus.OK);
    }
  
     
    
    //------------------- Delete a SalesOrder --------------------------------------------------------
    //Implemented
    @RequestMapping(value = "/SalesOrder/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<SalesOrder> deleteSalesOrder(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting SalesOrder with id " + id);
        //Implemented
        SalesOrderService.deleteSalesOrderById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
  
      
     
    //------------------- Delete All SalesOrders --------------------------------------------------------
      
    @RequestMapping(value = "/SalesOrder/", method = RequestMethod.DELETE)
    public ResponseEntity<SalesOrder> deleteAllSalesOrders() {
        System.out.println("Deleting All SalesOrders");
  
        SalesOrderService.deleteAllSalesOrders();
        return new ResponseEntity<SalesOrder>(HttpStatus.NO_CONTENT);
    }
  

}
