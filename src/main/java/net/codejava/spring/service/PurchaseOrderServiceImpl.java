package net.codejava.spring.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 









import net.codejava.spring.dao.PurchaseOrderDAO;
import net.codejava.spring.dao.PurchaseOrderDAOImpl;
import net.codejava.spring.model.Item;
import net.codejava.spring.model.OrderDetail;
import net.codejava.spring.model.PurchaseOrder;
 
@Service("PurchaseOrderService")
@Transactional
public class PurchaseOrderServiceImpl implements PurchaseOrderService{
     
    private static final AtomicInteger counter = new AtomicInteger();
     
    private static List<PurchaseOrder> orders;
    
	@Autowired
	private PurchaseOrderDAO purchaseorderDoa;
     
      public List<PurchaseOrder> findAllPurchaseOrders() {
        return populateDummyPurchaseOrders();
    }
     
    public PurchaseOrder findById(int id) {
    	try {
			return (PurchaseOrder) purchaseorderDoa.getPurchaseOrderByID(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
     
    
    public Integer savePurchaseOrder(PurchaseOrder PurchaseOrder) {
        PurchaseOrder.setId(counter.incrementAndGet());
            Calendar calendar = Calendar.getInstance();
             java.sql.Date orddt = new java.sql.Date(calendar.getTime().getTime());
             PurchaseOrder.setOrderDt(orddt);

        return purchaseorderDoa.addPurchaseOrder(PurchaseOrder);
    }
 
    public void updatePurchaseOrder(PurchaseOrder PurchaseOrder) {
    	purchaseorderDoa.updatePurchaseOrder(PurchaseOrder);
    }
 
    public void deletePurchaseOrderById(int id) {
    	purchaseorderDoa.deletePurchaseOrder(id);
  
    }
 
    public boolean isPurchaseOrderExist(PurchaseOrder so) {
      return purchaseorderDoa.getOrderByOrderNo(so.getOrderNumber()).size()>0;
    }
     
 

	public void deleteAllPurchaseOrders(){
      //  PurchaseOrders.clear();
    }
 
	 public List<PurchaseOrder> findByOrderNo(String orderno) {
	        
	    	try {
				return purchaseorderDoa.getOrderByOrderNo(orderno);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	    }
	 
    private List<PurchaseOrder> populateDummyPurchaseOrders(){
 		List<PurchaseOrder> listPurchaseOrders = null;
		try {
			listPurchaseOrders = purchaseorderDoa.listPurchaseOrders();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return listPurchaseOrders;
    }
 
   // @ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/applicationContext.xml"})
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("servlet-context.xml");
        //
          
        /* Add */
   	//	PurchaseOrderDAOImpl sodao = (PurchaseOrderDAOImpl) context.getBean("purchaseorderDoa");
        PurchaseOrderService soImpl = (PurchaseOrderService) context.getBean("purchaseOrderService");
 
        PurchaseOrder so1 = new PurchaseOrder();
        so1.setOrderNumber("DT11");
    //    Calendar calendar = Calendar.getInstance();
   //     java.sql.Date orddt = new java.sql.Date(calendar.getTime().getTime());
   //     so1.setOrderDate(orddt);

        Integer soID1 = soImpl.savePurchaseOrder(so1);
        /* List  */
        soImpl.findAllPurchaseOrders();

        /* Update  */
    
        PurchaseOrder so11 = (PurchaseOrder)soImpl.findAllPurchaseOrders().iterator().next();
        so11.setOrderNumber("ON111UPDATE");
 	
       //
  
        
    	System.exit(0);
    }

    
    private void getEample(){
	      ApplicationContext context = new ClassPathXmlApplicationContext("servlet-context.xml");

        PurchaseOrderService soImpl = (PurchaseOrderService) context.getBean("PurchaseOrderService");

        // List by Order Number
         PurchaseOrder so11 = soImpl.findByOrderNo("ON111UPDATE").iterator().next();
     }
	private void allExample(){
	      ApplicationContext context = new ClassPathXmlApplicationContext("servlet-context.xml");
	        
          
        /* Add */
   	//	PurchaseOrderDAOImpl sodao = (PurchaseOrderDAOImpl) context.getBean("purchaseorderDoa");
        PurchaseOrderService soImpl = (PurchaseOrderService) context.getBean("PurchaseOrderService");
 
        PurchaseOrder so1 = new PurchaseOrder();
        so1.setOrderNumber("ON111_NEWREAL");
        Integer soID1 = soImpl.savePurchaseOrder(so1);
        /* List  */
        soImpl.findAllPurchaseOrders();

        /* Update  */
    
        PurchaseOrder so11 = (PurchaseOrder)soImpl.findAllPurchaseOrders().iterator().next();
        so11.setOrderNumber("ON111UPDATE");

	}
}