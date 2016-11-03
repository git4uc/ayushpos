package com.usha;

 import java.util.*;

import net.codejava.spring.dao.OrderDAOImpl;
import net.codejava.spring.dao.SalesOrderDAOImpl;
import net.codejava.spring.model.Certificate;
import net.codejava.spring.model.Employee;



import net.codejava.spring.model.OrderDetail;
import net.codejava.spring.model.SalesOrder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSalesOrder {
 
	
  public static void main(String[] args) {
	     ApplicationContext context = new ClassPathXmlApplicationContext("servlet-context.xml");


     /* Let us have a set  */
     List set1 = new ArrayList();
     set1.add(new OrderDetail(330,23,23.4));
     set1.add(new OrderDetail(331,36,45.6));
        
     /* Add */
		SalesOrderDAOImpl sodao = (SalesOrderDAOImpl) context.getBean("salesorderDoa");

   //  Integer soID1 = sodao.addSalesOrder("OrderNO1", set1);
		SalesOrder so = new SalesOrder();
		so.setOrderNumber("NEWONEWHOLE");
		so.setOrderDetails(set1);
	/**	Hibernate: insert into orderheader (ordernumber, orderdate, totdiscount) values (?, ?, ?)
		Hibernate: insert into orderdetail (Item_id, qty, price) values (?, ?, ?) **/
	//	Integer soID1 = sodao.addSalesOrder(so);
		 
     /* List  */
  //   sodao.listSalesOrders();
     
     sodao.deleteSalesOrder(102);
     /* Update  */
 
   /**  SalesOrder so1 = (SalesOrder)sodao.listSalesOrders().iterator().next();
     so1.setOrderNumber("ON1_NEW");
     List ods1 =so1.getOrderDetails();
    for (Iterator it2 = 
               ods1.iterator(); it2.hasNext();){
        OrderDetail od = (OrderDetail) it2.next(); 
        od.setPrice(45.5);
        System.out.println("OrderDetailin test: " + od.getItemid()); 
  }
    // sodao.updateSalesOrder(soID1, "SSSDDDNEW"); **/
  //  sodao.updateSalesOrder(so1);
     /* Delete  */
//     sodao.deleteSalesOrder(soID1);

    // List down all 
     
     
  /**   try {
		sodao.updateSalesOrderByID(104);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     **/
     List so11 = sodao.listSalesOrders();
 

  }

  /**Session session = sessionFactory.openSession (); 
  Transaction tx = session.beginTransaction (); 
  String hqlUpdate = "update Customer set name =: newName where name =: oldName"; 
  int updatedEntities = s.createQuery (hqlUpdate). SetString ("newName ", newName). setString (" oldName ", oldName). executeUpdate (); 
  tx.commit (); 
  session.close (); **/
  
 
}
