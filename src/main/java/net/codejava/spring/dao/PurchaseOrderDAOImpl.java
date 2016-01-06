package net.codejava.spring.dao;

 import java.util.*;

import net.codejava.spring.dao.StockDAOImpl;
import net.codejava.spring.model.Certificate;
import net.codejava.spring.model.Employee;
import net.codejava.spring.model.Item;
import net.codejava.spring.model.OrderDetail;
import net.codejava.spring.model.PurchaseOrder;

import org.hibernate.HibernateException; 
import org.hibernate.Query;
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PurchaseOrderDAOImpl implements PurchaseOrderDAO {

	private SessionFactory sessionFactory;
    private Session session ;
	public PurchaseOrderDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
 

  /* Method to add an PurchaseOrder record in the database */
  public Integer addPurchaseOrder(String orderno, List details){
     Session session = sessionFactory.openSession();
     Transaction tx = null;
     Integer PurchaseOrderID = 0;
     try{
        tx = session.beginTransaction();
        PurchaseOrder purchaseOrder = new PurchaseOrder(orderno);
        Calendar calendar = Calendar.getInstance();
        java.sql.Date orddt = new java.sql.Date(calendar.getTime().getTime());
        purchaseOrder.setOrderDt(orddt);
       // purchaseOrder.setOrderDetails(details);
        PurchaseOrderID = (Integer) session.save(purchaseOrder); 
        tx.commit();
     }catch (HibernateException e) {
        if (tx!=null) tx.rollback();
        e.printStackTrace(); 
     }finally {
        session.close(); 
     }
     return PurchaseOrderID;
  }
  
  /* Method to add an PurchaseOrder record in the database */
  public Integer addPurchaseOrder(PurchaseOrder po){
     Session session = sessionFactory.openSession();
     Transaction tx = null;
     Integer PurchaseOrderID = null;
     try{
        tx = session.beginTransaction();
        Calendar calendar = Calendar.getInstance();
        java.sql.Date orddt = new java.sql.Date(calendar.getTime().getTime());
        po.setOrderDt(orddt);       
        PurchaseOrderID = (Integer) session.save(po); 
        tx.commit();
     }catch (HibernateException e) {
        if (tx!=null) tx.rollback();
        e.printStackTrace(); 
     }finally {
        session.close(); 
     }
     return PurchaseOrderID;
  }

  /* Method to list all the e detail */
  public List listPurchaseOrders( ){
     Session session = sessionFactory.openSession();
     Transaction tx = null;
     try{
        tx = session.beginTransaction();
        List purchaseorders = session.createQuery("FROM PurchaseOrder").list(); 
        for (Iterator iterator1 = 
        		purchaseorders.iterator(); iterator1.hasNext();){
           PurchaseOrder so = (PurchaseOrder) iterator1.next(); 
           System.out.print("Order Number: " + so.getOrderNumber()); 

        }
        tx.commit();
        return purchaseorders;
     }catch (HibernateException e) {
        if (tx!=null) tx.rollback();
        e.printStackTrace(); 
     }finally {
        session.close(); 
     }
	return null;
     
  }
  /* Method to update */
  public void updatePurchaseOrder(Integer purchaseOrderID, String ordernumber ){
     Session session = sessionFactory.openSession();
     Transaction tx = null;
     try{
        tx = session.beginTransaction();
        PurchaseOrder purchaseorder = 
                   (PurchaseOrder)session.get(PurchaseOrder.class, purchaseOrderID); 
        purchaseorder.setOrderNumber( ordernumber );
        session.update(purchaseorder);
        tx.commit();
     }catch (HibernateException e) {
        if (tx!=null) tx.rollback();
        e.printStackTrace(); 
     }finally {
        session.close(); 
     }
  }
  
  /* Method to update */
  public void updatePurchaseOrder(PurchaseOrder so ){
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
  public void deletePurchaseOrder(Integer PurchaseOrderID){
     Session session = sessionFactory.openSession();
     Transaction tx = null;
     try{
        tx = session.beginTransaction();
        PurchaseOrder purchaseorder = 
                  (PurchaseOrder)session.get(PurchaseOrder.class, PurchaseOrderID); 
        session.delete(purchaseorder); 
        tx.commit();
     }catch (HibernateException e) {
        if (tx!=null) tx.rollback();
        e.printStackTrace(); 
     }finally {
        session.close(); 
     }
  }



@Override
public List<PurchaseOrder> getOrderByOrderNo(String orderno) {
    Session session = sessionFactory.openSession();
    Transaction tx = null;
    try{
	/**Query query = session.createSQLQuery(
			"call GetSOByOrderNO(:orderno)")
			.addEntity(Item.class)
			.setParameter("orderno", orderno);
			List<PurchaseOrder> purchaseorders = query.list(); **/
    	List<PurchaseOrder> purchaseorders = session.createQuery("FROM PurchaseOrder where ordernumber like '"+orderno+"'").list(); 
		
       for (Iterator iterator1 = 
       		purchaseorders.iterator(); iterator1.hasNext();){
          PurchaseOrder so = (PurchaseOrder) iterator1.next(); 
          System.out.print("Order Number: " + so.getOrderNumber()); 

       }

       return purchaseorders;
}catch (HibernateException e) {
    if (tx!=null) tx.rollback();
    e.printStackTrace(); 
 }finally {
    session.close(); 
 }
return null;
 
}


@Override
public void deletePurchaseOrder(int id) {
	// TODO Auto-generated method stub
	
}



@Override
public List<PurchaseOrder> getPurchaseOrderByID(int soid) throws Exception {
	// TODO Auto-generated method stub
	return null;
}




}
