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
 









import net.codejava.spring.dao.SalesOrderDAO;
import net.codejava.spring.dao.SalesOrderDAOImpl;
import net.codejava.spring.model.Item;
import net.codejava.spring.model.OrderDetail;
import net.codejava.spring.model.SalesOrder;
 
@Service("SalesOrderService")
@Transactional
public class SalesOrderServiceImpl implements SalesOrderService{
     
    private static final AtomicInteger counter = new AtomicInteger();
     
    private static List<SalesOrder> orders;
    
	@Autowired
	private SalesOrderDAO salesorderDoa;
     
      public List<SalesOrder> findAllSalesOrders() {
        return populateDummySalesOrders();
    }
     
    public SalesOrder findById(int id) {
    	try {
			return (SalesOrder) salesorderDoa.getSalesOrderByID(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
     
    
    public Integer saveSalesOrder(SalesOrder SalesOrder) {
        SalesOrder.setId(counter.incrementAndGet());
            Calendar calendar = Calendar.getInstance();
             java.sql.Date orddt = new java.sql.Date(calendar.getTime().getTime());
             SalesOrder.setOrderDate(orddt);

        return salesorderDoa.addSalesOrder(SalesOrder);
    }
 
    public void updateSalesOrder(SalesOrder SalesOrder) {
    	salesorderDoa.updateSalesOrder(SalesOrder);
    }
 
    public void deleteSalesOrderById(int id) {
    	salesorderDoa.deleteSalesOrder(id);
  
    }
 
    public boolean isSalesOrderExist(SalesOrder so) {
      return salesorderDoa.getOrderByOrderNo(so.getOrderNumber()).size()>0;
    }
     
 

	public void deleteAllSalesOrders(){
      //  SalesOrders.clear();
    }
 
	 public List<SalesOrder> findByOrderNo(String orderno) {
	        
	    	try {
				return salesorderDoa.getOrderByOrderNo(orderno);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	    }
	 
    private List<SalesOrder> populateDummySalesOrders(){
 		List<SalesOrder> listSalesOrders = null;
		try {
			listSalesOrders = salesorderDoa.listSalesOrders();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return listSalesOrders;
    }
 
   // @ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/applicationContext.xml"})
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("servlet-context.xml");
        //
        /* Let us have a set of order details  */
        List set1 = new ArrayList();
        set1.add(new OrderDetail(1,23,23.4));
        set1.add(new OrderDetail(2,36,45.6));
           
        /* Add */
   	//	SalesOrderDAOImpl sodao = (SalesOrderDAOImpl) context.getBean("salesorderDoa");
        SalesOrderService soImpl = (SalesOrderService) context.getBean("SalesOrderService");
 
        SalesOrder so1 = new SalesOrder();
        so1.setOrderNumber("DT11");
        so1.setTotDis(10);
    //    Calendar calendar = Calendar.getInstance();
   //     java.sql.Date orddt = new java.sql.Date(calendar.getTime().getTime());
   //     so1.setOrderDate(orddt);
        so1.setOrderDetails((List<OrderDetail>) set1);
        Integer soID1 = soImpl.saveSalesOrder(so1);
        /* List  */
        soImpl.findAllSalesOrders();

        /* Update  */
    
        SalesOrder so11 = (SalesOrder)soImpl.findAllSalesOrders().iterator().next();
        so11.setOrderNumber("ON111UPDATE");
        List<OrderDetail> ods1 =so11.getOrderDetails();
       for (Iterator it2 = 
                  ods1.iterator(); it2.hasNext();){
           OrderDetail od = (OrderDetail) it2.next(); 
           od.setPrice(45.5);
           System.out.println("OrderDetailin test: " + od.getItemid()); 
     }
	
       //
  
        
    	System.exit(0);
    }

    
    private void getEample(){
	      ApplicationContext context = new ClassPathXmlApplicationContext("servlet-context.xml");

        SalesOrderService soImpl = (SalesOrderService) context.getBean("SalesOrderService");

        // List by Order Number
         SalesOrder so11 = soImpl.findByOrderNo("ON111UPDATE").iterator().next();
         List<OrderDetail>  ods12 = so11.getOrderDetails();
      for (Iterator it22 = 
                 ods12.iterator(); it22.hasNext();){
          OrderDetail od2 = (OrderDetail) it22.next(); 
          System.out.println("OrderDetailin test: " + od2.getItemid()); 
    }
    }
	private void allExample(){
	      ApplicationContext context = new ClassPathXmlApplicationContext("servlet-context.xml");
	        
        /* Let us have a set of order details  */
        List set1 = new ArrayList();
        set1.add(new OrderDetail(1,23,23.4));
        set1.add(new OrderDetail(2,36,45.6));
           
        /* Add */
   	//	SalesOrderDAOImpl sodao = (SalesOrderDAOImpl) context.getBean("salesorderDoa");
        SalesOrderService soImpl = (SalesOrderService) context.getBean("SalesOrderService");
 
        SalesOrder so1 = new SalesOrder();
        so1.setOrderNumber("ON111_NEWREAL");
        so1.setOrderDetails((List<OrderDetail>) set1);
        Integer soID1 = soImpl.saveSalesOrder(so1);
        /* List  */
        soImpl.findAllSalesOrders();

        /* Update  */
    
        SalesOrder so11 = (SalesOrder)soImpl.findAllSalesOrders().iterator().next();
        so11.setOrderNumber("ON111UPDATE");
        List<OrderDetail> ods1 =so11.getOrderDetails();
       for (Iterator it2 = 
                  ods1.iterator(); it2.hasNext();){
           OrderDetail od = (OrderDetail) it2.next(); 
           od.setPrice(45.5);
           System.out.println("OrderDetailin test: " + od.getItemid()); 
     }
	}
}