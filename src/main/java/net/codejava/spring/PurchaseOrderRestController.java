package net.codejava.spring;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;














import java.util.Set;

import net.codejava.spring.dao.PurchaseOrderDAO;
import net.codejava.spring.dao.UserDAO;
import net.codejava.spring.model.OrderDetail;
import net.codejava.spring.model.PurchaseOrder;
import net.codejava.spring.service.PurchaseOrderService;
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
public class PurchaseOrderRestController {

	@Autowired
	   PurchaseOrderService purchaseOrderService;  //Service which will do all data retrieval/manipulation work 
	
    //-------------------Retrieve All PurchaseOrders--------------------------------------------------------
	
      
	@RequestMapping(value = "/PurchaseOrder/", method = RequestMethod.GET)
    public ResponseEntity <List<PurchaseOrder>> listAllPurchaseOrders() throws Exception {
    	System.out.println("Testing testing /cagepos/PurchaseOrder Y - 1/14");
    	//Implemeted - Usha
    
       List<PurchaseOrder> PurchaseOrders = purchaseOrderService.findAllPurchaseOrders();
        if(PurchaseOrders.isEmpty()){
            return new ResponseEntity<List<PurchaseOrder>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
		for(int i=0; i<PurchaseOrders.size(); i++){
			PurchaseOrder PurchaseOrder = (PurchaseOrder)PurchaseOrders.get(i);
			System.out.println(PurchaseOrder.getOrderNumber());
		}
        return new ResponseEntity<List<PurchaseOrder>>(PurchaseOrders, HttpStatus.OK);
    }
     
    //-------------------Retrieve Single PurchaseOrder--------------------------------------------------------
      
    @RequestMapping(value = "/PurchaseOrder/single/{id}", method = RequestMethod.GET)
    public ResponseEntity<PurchaseOrder> getPurchaseOrder(@PathVariable("id") int id) {
        System.out.println("Fetching PurchaseOrder with id " + id);
      //Implemeted - Usha
        PurchaseOrder PurchaseOrder = purchaseOrderService.findById(id);
        if (PurchaseOrder == null) {
            System.out.println("PurchaseOrder with id " + id + " not found");
            return new ResponseEntity<PurchaseOrder>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PurchaseOrder>(PurchaseOrder, HttpStatus.OK);
    }
  
      
      
    //-------------------find a PurchaseOrder--------------------------------------------------------
    @RequestMapping(value = "/PurchaseOrder/{pno}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PurchaseOrder>> getPurchaseOrder(@PathVariable("pno") String pno) {
        System.out.println("Fetching PurchaseOrder with name " + pno);
      //Implemeted - Usha
        List<PurchaseOrder> PurchaseOrders = purchaseOrderService.findByOrderNo(pno);
        if (PurchaseOrders == null) {
            System.out.println("PurchaseOrder with id " + pno + " not found");
            return new ResponseEntity<List<PurchaseOrder>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<PurchaseOrder>>(PurchaseOrders, HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/PurchaseOrder/", method = RequestMethod.POST)
    public ResponseEntity<Void> createPurchaseOrder(@RequestBody PurchaseOrder PurchaseOrder,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating PurchaseOrder " + PurchaseOrder.getOrderNumber());
  
        if (purchaseOrderService.isPurchaseOrderExist(PurchaseOrder)) {
            System.out.println("A PurchaseOrder with name " + PurchaseOrder.getOrderNumber()+ " already exist");
            ErrorResponse errResp = new ErrorResponse(ErrorCode.INVALID_ID);
         //   return new ResponseEntity<Void>(HttpStatus.CONFLICT);
          //  return Response.status(400).entity(resp).build();
            return new ResponseEntity(errResp,HttpStatus.BAD_REQUEST);
        }
      //Implemeted - Usha
        purchaseOrderService.savePurchaseOrder(PurchaseOrder);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/PurchaseOrder/{id}").buildAndExpand(PurchaseOrder.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
  
     
      
    //------------------- Update a PurchaseOrder --------------------------------------------------------
      
    @RequestMapping(value = "/PurchaseOrder/{id}", method = RequestMethod.PUT)
    public ResponseEntity<PurchaseOrder> updatePurchaseOrder(@PathVariable("id") int id, @RequestBody PurchaseOrder purchaseOrder) {
        System.out.println("Updating PurchaseOrder " + id);
          
        PurchaseOrder currentPurchaseOrder = purchaseOrderService.findById(id);
        
        if (currentPurchaseOrder==null) {
            System.out.println("PurchaseOrder with id " + id + " not found");
            return new ResponseEntity<PurchaseOrder>(HttpStatus.BAD_REQUEST);
        }
        System.out.println("PurchaseOrder with id " + id + "  found ");
        purchaseOrder.setId(currentPurchaseOrder.getId());


        purchaseOrderService.updatePurchaseOrder(purchaseOrder);
        
        return new ResponseEntity<PurchaseOrder>(purchaseOrderService.findById(id), HttpStatus.OK);
    }
  
     
    
    //------------------- Delete a PurchaseOrder --------------------------------------------------------
    //Implemented
    @RequestMapping(value = "/PurchaseOrder/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<PurchaseOrder> deletePurchaseOrder(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting PurchaseOrder with id " + id);
        //Implemented
        purchaseOrderService.deletePurchaseOrderById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
  
      
     
    //------------------- Delete All PurchaseOrders --------------------------------------------------------
      
    @RequestMapping(value = "/PurchaseOrder/", method = RequestMethod.DELETE)
    public ResponseEntity<PurchaseOrder> deleteAllPurchaseOrders() {
        System.out.println("Deleting All PurchaseOrders");
  
        purchaseOrderService.deleteAllPurchaseOrders();
        return new ResponseEntity<PurchaseOrder>(HttpStatus.NO_CONTENT);
    }
  

}
