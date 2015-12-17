package net.codejava.spring.model;

import java.util.*;

public class SalesOrder1 {
   private int id;
   private String ordernumber; 
   private Set orderdetails;

   public SalesOrder1() {}
   public SalesOrder1(String orderno) {
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

   public Set getOrderDetails() {
      return orderdetails;
   }


public void setOrderDetails(Set details) {
	this.orderdetails = details;
	
}
}