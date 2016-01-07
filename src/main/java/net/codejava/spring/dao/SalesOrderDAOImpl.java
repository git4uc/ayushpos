package net.codejava.spring.dao;

 import java.util.*;

import net.codejava.spring.dao.StockDAOImpl;
import net.codejava.spring.model.Certificate;
import net.codejava.spring.model.Employee;
import net.codejava.spring.model.Item;
import net.codejava.spring.model.OrderDetail;
import net.codejava.spring.model.SalesOrder;

import org.hibernate.HibernateException; 
import org.hibernate.Query;
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SalesOrderDAOImpl implements SalesOrderDAO {

	private SessionFactory sessionFactory;
    private Session session ;
	public SalesOrderDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
 

  /* Method to add an SalesOrder record in the database */
  public Integer addSalesOrder(String orderno, List details){
     Session session = sessionFactory.openSession();
     Transaction tx = null;
     Integer SalesOrderID = 0;
     try{
        tx = session.beginTransaction();
        SalesOrder salesOrder = new SalesOrder(orderno);
        Calendar calendar = Calendar.getInstance();
        java.sql.Date orddt = new java.sql.Date(calendar.getTime().getTime());
        salesOrder.setOrderDate(orddt);

        salesOrder.setOrderDetails(details);
        SalesOrderID = (Integer) session.save(salesOrder); 
        tx.commit();
     }catch (HibernateException e) {
        if (tx!=null) tx.rollback();
        e.printStackTrace(); 
     }finally {
        session.close(); 
     }
     return SalesOrderID;
  }
  
  /* Method to add an SalesOrder record in the database */
  public Integer addSalesOrder(SalesOrder so){
     Session session = sessionFactory.openSession();
     Transaction tx = null;
     Integer SalesOrderID = null;
     try{
        tx = session.beginTransaction();
        Calendar calendar = Calendar.getInstance();
        java.sql.Date orddt = new java.sql.Date(calendar.getTime().getTime());
        so.setOrderDate(orddt);
        SalesOrderID = (Integer) session.save(so); 
        tx.commit();
     }catch (HibernateException e) {
        if (tx!=null) tx.rollback();
        e.printStackTrace(); 
     }finally {
        session.close(); 
     }
     return SalesOrderID;
  }

  /* Method to list all the e detail */
  public List listSalesOrders( ){
     Session session = sessionFactory.openSession();
     Transaction tx = null;
     try{
        tx = session.beginTransaction();
        List salesorders = session.createQuery("FROM SalesOrder").list(); 
        for (Iterator iterator1 = 
        		salesorders.iterator(); iterator1.hasNext();){
           SalesOrder so = (SalesOrder) iterator1.next(); 
           System.out.print("Order Number: " + so.getOrderNumber()); 
           List ods = so.getOrderDetails();
           for (Iterator iterator2 =  ods.iterator(); iterator2.hasNext();){
                 OrderDetail od = (OrderDetail) iterator2.next(); 
                 System.out.println("OrderDetail: " + od.getItemid()); 
           }
        }
        tx.commit();
        return salesorders;
     }catch (HibernateException e) {
        if (tx!=null) tx.rollback();
        e.printStackTrace(); 
     }finally {
        session.close(); 
     }
	return null;
     
  }
  /* Method to update */
  public void updateSalesOrder(Integer salesOrderID, String ordernumber ){
     Session session = sessionFactory.openSession();
     Transaction tx = null;
     try{
        tx = session.beginTransaction();
        SalesOrder salesorder = 
                   (SalesOrder)session.get(SalesOrder.class, salesOrderID); 
        salesorder.setOrderNumber( ordernumber );
        session.update(salesorder);
        tx.commit();
     }catch (HibernateException e) {
        if (tx!=null) tx.rollback();
        e.printStackTrace(); 
     }finally {
        session.close(); 
     }
  }
  
  /* Method to update */
  public void updateSalesOrder(SalesOrder so ){
     Session session = sessionFactory.openSession();
     Transaction tx = null;
     try{
        tx = session.beginTransaction();
        session.update(so);
        tx.commit();
     }catch (HibernateException e) {
        if (tx!=null) tx.rollback();
        e.printStackTrace(); 
     }finally {
        session.close(); 
     }
  }
  
  /* Method to delete  */
  public void deleteSalesOrder(Integer SalesOrderID){
     Session session = sessionFactory.openSession();
     Transaction tx = null;
     try{
        tx = session.beginTransaction();
        SalesOrder salesorder = 
                  (SalesOrder)session.get(SalesOrder.class, SalesOrderID); 
        session.delete(salesorder); 
        tx.commit();
     }catch (HibernateException e) {
        if (tx!=null) tx.rollback();
        e.printStackTrace(); 
     }finally {
        session.close(); 
     }
  }



@Override
public List<SalesOrder> getOrderByOrderNo(String orderno) {
    Session session = sessionFactory.openSession();
    Transaction tx = null;
    try{
	/**Query query = session.createSQLQuery(
			"call GetSOByOrderNO(:orderno)")
			.addEntity(Item.class)
			.setParameter("orderno", orderno);
			List<SalesOrder> salesorders = query.list(); **/
    	List<SalesOrder> salesorders = session.createQuery("FROM SalesOrder where ordernumber like '"+orderno+"'").list(); 
		
       for (Iterator iterator1 = 
       		salesorders.iterator(); iterator1.hasNext();){
          SalesOrder so = (SalesOrder) iterator1.next(); 
          System.out.print("Order Number: " + so.getOrderNumber()); 
          List ods = so.getOrderDetails();
          for (Iterator iterator2 =  ods.iterator(); iterator2.hasNext();){
                OrderDetail od = (OrderDetail) iterator2.next(); 
                System.out.println("OrderDetail: " + od.getItemid()); 
          }
       }

       return salesorders;
}catch (HibernateException e) {
    if (tx!=null) tx.rollback();
    e.printStackTrace(); 
 }finally {
    session.close(); 
 }
return null;
 
}


@Override
public void deleteSalesOrder(int id) {
	// TODO Auto-generated method stub
	
}



@Override
public SalesOrder getSalesOrderByID(int soid) throws Exception {
    Session session = sessionFactory.openSession();
    Transaction tx = null;
    try{
	/**Query query = session.createSQLQuery(
			"call GetSOByOrderNO(:orderno)")
			.addEntity(Item.class)
			.setParameter("orderno", orderno);
			List<SalesOrder> salesorders = query.list(); **/
    SalesOrder salesorders = (SalesOrder) session.createQuery("FROM SalesOrder where id = '"+soid+"'").list().iterator().next(); 
		
      return salesorders;
}catch (HibernateException e) {
    if (tx!=null) tx.rollback();
    e.printStackTrace(); 
 }finally {
    session.close(); 
 }
	return null;
}




}
