package net.codejava.spring.model;

import java.util.*;

public class SalesOrder {
   private int id;
   private String ordernumber; 
   //private Set orderdetails;
   private List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
   
   public SalesOrder() {}
   public SalesOrder(String orderno) {
      this.ordernumber = orderno;
   }
   public int getId() {
      return id;
   }
   public void setId( int id ) {
      this.id = id;
   }
   public String getOrderNumber() {
      return ordernumber;
   }
   public void setOrderNumber( String ordernumber ) {
      this.ordernumber = ordernumber;
   }

   /**
   * 
   * @return
   * The orderDetails
   */
   public List<OrderDetail> getOrderDetails() {
   return orderDetails;
   }

   /**
   * 
   * @param orderDetails
   * The orderDetails
   */
   public void setOrderDetails(List<OrderDetail> orderDetails) {
   this.orderDetails = orderDetails;
   }
	
}
