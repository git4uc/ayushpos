package net.codejava.spring.model;
import java.util.*;

	public class PurchaseOrder {
	   private int id;
	   private String ordernumber; 
	   private double rate;
	   private Date orderDt;
	   private Date deliveryDt;
	   private int qty;
	   private String notes;
	   private int itemId;
	   private Supplier sup;
	   private double totAmt;
	   
	   //private Set orderdetails;

	   public PurchaseOrder() {}
	   public PurchaseOrder(String orderno) {
	      this.ordernumber = orderno;
	   }
	   public int getId() {
	      return id;
	   }
	   public void setId( int id ) {
	      this.id = id;
	   }
	   public Date getOrderDt() {
		return orderDt;
	   }
	   public void setOrderDt( Date orderdt ) {
	      this.orderDt = orderdt;
	   }
	   
	   public Date getDeliveryDt() {
		return deliveryDt;
	   }
	   public void setDeliveryDt( Date delidt ) {
	      this.deliveryDt = delidt;
	   }
	   
	   public String getOrderNumber() {
		      return ordernumber;
		   }
		   public void setOrderNumber( String ordernumber ) {
		      this.ordernumber = ordernumber;
		   }
		   

	

	
	public int getQty() {

		return qty;
	}
	public void setQty(int totQty) {
		this.qty = totQty;
	}


	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	

	
	public Supplier getSup() {
		return sup;
	}
	public void setSup(Supplier sup) {
		this.sup = sup;
	}
	public double getTotAmt() {
		return totAmt;
	}
	public void setTotAmt(double totAmt) {
		this.totAmt = totAmt;
	}
		

	
}


